package com.project.apidata.libapi.helper;

import com.project.apidata.libapi.entity.FriendsLocation;
import com.project.apidata.libapi.entity.MyLocation;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyExcelHelper {

    public static boolean checkExcelFormat(MultipartFile file){
        String contentType = file.getContentType();
        if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
            return true;
        }else {
            return false;
        }

    }

    //convert excel to list of loc data;

    public static List<MyLocation> excelToListLocation(InputStream is){
        List<MyLocation> myList = new ArrayList<>();

        try {

            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while(iterator.hasNext()){
                Row row = iterator.next();
                if(rowNumber == 0){
                    rowNumber++;
                    continue;
                }

               Iterator<Cell> cells =  row.iterator();
                int cid = 0;

                MyLocation ml = new MyLocation();
                while(cells.hasNext()){
                    Cell cell = cells.next();

                    switch (cid){
                        case 0
                                :
                            ml.setTime((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            ml.setMyLatitude(cell.getNumericCellValue());
                        case 2:
                            ml.setMyLongitude(cell.getNumericCellValue());
                            break;
                        case 3:
                            ml.setSpeed((int) cell.getNumericCellValue());
                            break;
                        default:
                            break;

                    }

                    cid++;

                }

                myList.add(ml);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return myList;
    }

    public static List<FriendsLocation> excelToListFriend(InputStream is){
        List<FriendsLocation> friendList = new ArrayList<>();

        try {

            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("Sheet2");
            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while(iterator.hasNext()){
                Row row = iterator.next();
                if(rowNumber == 0){
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells =  row.iterator();
                int cid = 0;

                FriendsLocation fl = new FriendsLocation();
                while(cells.hasNext()){
                    Cell cell = cells.next();

                    switch (cid){
                        case 0:
                            fl.setFriendId((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            fl.setFriend(cell.getStringCellValue());
                            break;
                        case 2:
                            fl.setFriendLatitude(cell.getNumericCellValue());
                            break;
                        case 3:
                            fl.setFriendLongitude(cell.getNumericCellValue());
                            break;
                        default:
                            break;

                    }

                    cid++;

                }

                friendList.add(fl);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return friendList;
    }

}
