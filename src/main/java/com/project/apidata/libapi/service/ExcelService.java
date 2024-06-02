package com.project.apidata.libapi.service;

import com.project.apidata.libapi.entity.MyLocation;
import com.project.apidata.libapi.helper.MyExcelHelper;
import com.project.apidata.libapi.repo.MyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private MyRepo myRepo;

    public void save(MultipartFile file) {
        try {
            List<MyLocation> myLocations = MyExcelHelper.excelToListLocation(file.getInputStream());
            this.myRepo.saveAll(myLocations);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<MyLocation> getAllMyData(){
            return this.myRepo.findAll();
    }
}
