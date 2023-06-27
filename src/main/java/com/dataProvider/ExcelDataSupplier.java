package com.dataProvider;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class ExcelDataSupplier {
    @DataProvider(name = "loginData")
    public Object[][] getData() throws Exception {
        File excelFile = new File("src\\main\\resources\\testData.xlsx");
        System.out.println(excelFile.exists());
        FileInputStream fis = new FileInputStream(excelFile);
        //for older version- xls-- HSSF
        //for newer version- xlsx-- XSSF
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("loginData");
        int numberOfRows = sheet.getPhysicalNumberOfRows();
        int noOfColumns = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[numberOfRows-1][noOfColumns];
        for(int i=0; i<numberOfRows-1; i++) {
            for(int j=0; j<noOfColumns; j++) {
                //It is used when no information is available that which type of data stored in Excel file.
                DataFormatter df = new DataFormatter();
                data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
                //getStringCellValue() is used when Excel file contains only String value.
                //System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
            }
            System.out.println();
        }
        workbook.close();
        fis.close();
        for (Object[] arrayData: data) {
            System.out.println(Arrays.toString(arrayData));
        }
        return data;
    }
}
