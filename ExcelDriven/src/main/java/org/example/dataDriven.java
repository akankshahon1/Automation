package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class dataDriven {

        public ArrayList<String> getdata(String testcaseName) throws IOException {
            ArrayList<String> a=new ArrayList<String>();
            FileInputStream fis = new FileInputStream("C://Users//e326099//Documents//dataexcel.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            //identify testcases column by scanning entire 1st roq
            int sheets= workbook.getNumberOfSheets();
            for(int i=0;i<sheets;i++){
                if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
                    XSSFSheet sheet = workbook.getSheetAt(i);

                    Iterator<Row> rows= sheet.iterator();       //sheet is collection of rows
                    Row firstrow= rows.next();
                    Iterator<Cell> ce= firstrow.cellIterator();  // row is collection of cells
                    int k=0;
                    int column=0;
                    while(ce.hasNext()){
                        Cell value= ce.next();
                        if( value.getStringCellValue().equalsIgnoreCase("Testcases"))
                        {
                            //desired column
                            column=k;
                        }
                        k++;
                    }


                    System.out.println(column);
                    //once column is identified then scan entire testcase column to identify purchase testcase row

                    while(rows.hasNext()){
                        Row r= rows.next();
                        if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)){
                            //after you grab purchase testcase row=pull all data of that row and feed into test
                            Iterator<Cell> cv = r.cellIterator();
                            while(cv.hasNext()){
                                a.add(cv.next().getStringCellValue());
                            }
                        }
                    }
                }
            }

            return a;
        }
    public static void main(String[] args) throws IOException {
        //fileinput stream object
    }
}