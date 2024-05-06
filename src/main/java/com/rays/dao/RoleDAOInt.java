package com.rays.dao;

import com.rays.dto.RoleDTO;

import java.util.List;

public interface RoleDAOInt {
    public RoleDTO findByPk(long pk);

    public List search(RoleDTO dto, int pageNo, int pageSize);


}
