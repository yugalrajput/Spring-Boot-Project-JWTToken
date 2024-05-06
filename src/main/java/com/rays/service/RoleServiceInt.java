package com.rays.service;

import com.rays.dto.RoleDTO;

import java.util.List;

public interface RoleServiceInt {
    public List search(RoleDTO dto, int pageNo, int pageSize);
}
