package com.project.apidata.libapi.repo;

import com.project.apidata.libapi.entity.MyLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepo extends JpaRepository<MyLocation, Integer> {
}
