package com.rays.dao;

import com.rays.dto.UserDTO;

import java.util.List;

public interface UserDAOInt {

    public long add(UserDTO dto);

    public void update(UserDTO dto);

    public void delete(UserDTO dto);

    public UserDTO findByPk(long pk);

    public UserDTO findByUniqueKey(String attribute, String value);

    public List search(UserDTO dto, int pageNo, int pageSize);

}
