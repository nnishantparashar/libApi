package com.project.apidata.libapi.controller;

import com.project.apidata.libapi.entity.FriendsLocation;
import com.project.apidata.libapi.entity.MyLocation;
import com.project.apidata.libapi.helper.MyExcelHelper;
import com.project.apidata.libapi.service.ExcelService;
import com.project.apidata.libapi.service.FriendExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin("*")
public class myController {

    @Autowired
    private ExcelService excelService;
    @Autowired
    private FriendExcelService friendExcelService;

    @PostMapping("/uploadMydata")
    public ResponseEntity<?> uploadMyData(@RequestParam("file")MultipartFile file){
        if(MyExcelHelper.checkExcelFormat(file)){
            this.excelService.save(file);

            return ResponseEntity.status(HttpStatus.OK).body("File is uploaded successfully.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file.");
    }

    @GetMapping("/getMyData")
    public List<MyLocation> getMyData(){
        return this.excelService.getAllMyData();
    }

    @PostMapping("/uploadFriendData")
    public ResponseEntity<?> uploadFriendData(@RequestParam("file")MultipartFile file){
        if(MyExcelHelper.checkExcelFormat(file)){
            this.friendExcelService.save(file);

            return ResponseEntity.status(HttpStatus.OK).body("File is uploaded successfully.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file.");
    }


    @GetMapping("/getFriendData")
    public List<FriendsLocation> getFriendData(){
        return this.friendExcelService.getAllMyData();
    }
}
