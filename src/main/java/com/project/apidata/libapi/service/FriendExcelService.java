package com.project.apidata.libapi.service;

import com.project.apidata.libapi.entity.FriendsLocation;
import com.project.apidata.libapi.helper.MyExcelHelper;
import com.project.apidata.libapi.repo.FriendsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FriendExcelService {

    @Autowired
    private FriendsRepo friendsRepo;

    public void save(MultipartFile file) {
        try {
            List<FriendsLocation> friendLocations = MyExcelHelper.excelToListFriend(file.getInputStream());
            this.friendsRepo.saveAll(friendLocations);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<FriendsLocation> getAllMyData(){
        return this.friendsRepo.findAll();
    }

}
