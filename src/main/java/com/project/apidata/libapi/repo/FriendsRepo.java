package com.project.apidata.libapi.repo;

import com.project.apidata.libapi.entity.FriendsLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendsRepo extends JpaRepository<FriendsLocation, Integer> {
}
