package com.nopecommerce.admin.helper.excel;

import com.nopecommerce.admin.helper.select.DropdownHelper;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExcelHelper {
    private Logger log = Logger.getLogger(ExcelHelper.class);

    public Object[][] getExcelData(String excelLocation,String sheetName){
        try {
            Object dataSet[][]=null;
            FileInputStream file=new FileInputStream(excelLocation);

            //create workbook instance
            XSSFWorkbook workbook=new XSSFWorkbook(file);

            //get sheet by sheetName
            XSSFSheet sheet=workbook.getSheet(sheetName);

            //count number of active rows in sheet
            int totolRows=sheet.getLastRowNum();

            //count active columns in row
            int totalColumns=sheet.getRow(0).getLastCellNum();

            dataSet=new String[totolRows][totalColumns];

            //Iterate through each rows one by one
            Iterator<Row> rowIterator=sheet.iterator();
            int i=0;
            while (rowIterator.hasNext()){
                i++;
                Row row=rowIterator.next();

                Iterator<Cell> cellIterator=row.cellIterator();
                int j=0;
                while (cellIterator.hasNext()){
                    j++;
                    Cell cell = cellIterator.next();

                    switch (cell.getCellTypeEnum()){
                        case STRING:
                            dataSet[i][j]=cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            dataSet[i][j]=cell.getNumericCellValue();
                            break;
                        case BOOLEAN:
                            dataSet[i][j]=cell.getBooleanCellValue();
                            break;
                        case FORMULA:
                            dataSet[i][j]=cell.getCellFormula();
                            break;

                        default:
                            System.out.println("No matching data found..");
                            break;


                            
                    }
                }
                return dataSet;
            }



        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public Map<Object, Object> getExcelDataByMap(String excelLocation,String sheetName){
        try {
           // String excelLocation="E:\\OrangeHRMData\\systemUser.xlsx";
            //String sheetName="UserNameData";
            FileInputStream file = new FileInputStream(excelLocation);

            //create workbook instance
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            
            //get sheet by sheetName
            XSSFSheet sheet = workbook.getSheet(sheetName);

            //count number of active rows in sheet
            int totalRows = sheet.getLastRowNum();

            //count active columns in row
            int totalColumns=sheet.getRow(0).getLastCellNum();

            Map<Object, Object> mapData=new HashMap<Object, Object>();

            for(int i=0;i<totalRows;i++){
                for(int j=0;j<totalColumns;j++){
                    //add key and values
                    mapData.put(sheet.getRow(0).getCell(j).getStringCellValue(),sheet.getRow(i+1).getCell(j).getStringCellValue());

                }
            }

            return mapData;
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
