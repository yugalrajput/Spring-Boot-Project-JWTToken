package com.rays.service;

import com.rays.dto.UserDTO;

import java.util.List;

public interface UserServiceInt {
    public long add(UserDTO dto);

    public void update(UserDTO dto);

    public void delete(long dto);

    public UserDTO findById(long pk);

    public UserDTO authenticate(String loginId, String password);

    public List search(UserDTO dto, int pageNo, int pageSize);

    public UserDTO findByLogin(String login);
}
