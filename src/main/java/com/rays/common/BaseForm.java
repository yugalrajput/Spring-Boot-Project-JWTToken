package com.rays.common;

public class BaseForm {
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public <T extends BaseDTO> T initDTO(T dto) {
        if (id != null && id > 0) {
            dto.setId(id);
        } else {
            dto.setId(null);
        }
        return dto;

    }
}
