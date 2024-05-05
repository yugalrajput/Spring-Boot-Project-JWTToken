package com.rays.ctl;

import javax.validation.Valid;

import com.rays.service.UserServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.config.JWTUtil;
import com.rays.dto.UserDTO;
import com.rays.form.LoginForm;
import com.rays.form.UserRegistrationForm;

@RestController
@RequestMapping(value = "Auth")
public class LoginCtl extends BaseCtl {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    public UserServiceInt service;

    @PostMapping("login")
    public ORSResponse login(@RequestBody @Valid LoginForm form, BindingResult bindingResult) {

        ORSResponse res = validate(bindingResult);

        if (!res.isSuccess()) {
            return res;
        }

        UserDTO dto = service.authenticate(form.getLoginId(), form.getPassword());
        if (dto != null) {
            String token = jwtUtil.generateToken(form.getLoginId());
            res.addData(dto);
            res.addResult("token", token);
        } else {
            res.setSuccess(false);
            res.addMessage("Login ID & Password is invalid..!!");
        }
        return res;
    }

    @PostMapping("signUp")
    public ORSResponse signUp(@RequestBody @Valid UserRegistrationForm form, BindingResult bindingResult) {

        ORSResponse res = validate(bindingResult);

        if (!res.isSuccess()) {
            return res;
        }

        UserDTO dto = new UserDTO();

        dto.setFirstName(form.getFirstName());
        dto.setLastName(form.getLastName());
        dto.setLoginId(form.getLoginId());
        dto.setPassword(form.getPassword());
        dto.setDob(form.getDob());
        //dto.setRoleId(2L);

        long pk = service.add(dto);

        res.addData(pk);
        res.addMessage("Data Registered Successfully..!!");
        return res;
    }
}