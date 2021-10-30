package com.example.hocjavaweb.repo;

import com.example.hocjavaweb.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo {
    private List<UserEntity> listUser = new ArrayList<>();

    public void add(UserEntity userEntity){
        listUser.add(userEntity);
    }

    public List<UserEntity> getAll(){
        return listUser;
    }
}
