package com.blogApp.blogserver.controller;
import java.util.Collections;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogApp.blogserver.dao.AdminDao;
import com.blogApp.blogserver.entity.Admin;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminDao admindao;

    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody Admin admin) {
        logger.info("Login attempt for userId: {}", admin.getUserId());
        Optional<Admin> optionalAdmin = admindao.findById(admin.getUserId());
        if (!optionalAdmin.isPresent()) {
            logger.warn("Admin not found for userId: {}", admin.getUserId());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("message", "Admin not found"));
        }
        Admin ad = optionalAdmin.get();
        logger.info("Admin found: {}", ad);
        if (ad.getPassword().equals(admin.getPassword())) {
            logger.info("Login successful for userId: {}", admin.getUserId());
            return ResponseEntity.ok(Collections.singletonMap("message", "Login successful"));
        } else {
            logger.warn("Invalid credentials for userId: {}", admin.getUserId());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("message", "Invalid credentials"));
        }
    }

}

