package com.example.hocjavaweb.service;

import com.example.hocjavaweb.dto.CreateUserDTO;
import com.example.hocjavaweb.entity.UserEntity;
import com.example.hocjavaweb.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public String createUser(CreateUserDTO request) {
        // Bước 1: Thông tin nhập vào có hay chưa
        // Bước 2: kiểm tra xem password có  = retypePassword không;
        // Bước 2.1 Kiểm tra user và password có đúng định dạng hay không: REGEX = biểu thức chính quy
        // Bước 3: Kiểm tra xem username đã tồn tại hay chưa, nếu tồn tại thì thông báo lỗi
        // Bước 4: Thêm vào
        String response;
        if(request == null) {
            response = "Thông tin gửi lên không được trống";
            return response;
        }
        if(request.getUsername() == null || request.getUsername().isEmpty()){
            response = "Username không đước trống";
            return response;
        }
        if(request.getPassword() == null || request.getPassword().isEmpty()){
            response = "Password không được trống";
            return response;
        }
        if(request.getRetypePassword() == null || request.getRetypePassword().isEmpty()){
            return  "retypePassword không được trống";
        }
        ///// Bước 2
        if(! request.getRetypePassword().equals(request.getPassword())){
            return  "Password nhập lại không đúng";
        }
        // Bước 3
        List<UserEntity> users = userRepo.getAll();
        boolean checkDuplicate = false;

        for(int i = 0; i<users.size(); i++){
            if(users.get(i).getUsername().equals(request.getUsername())){
                checkDuplicate = true;
                break;
            }
        }
        if(checkDuplicate == true){
            return "username đã tồn tại trong hệ thống";
        }

        // Bước 4- insert ==> Convert sang userEntity rồi thêm vào list
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(request.getPassword());
        userRepo.add(userEntity);
        return "Them thanh cong";
    }
}

