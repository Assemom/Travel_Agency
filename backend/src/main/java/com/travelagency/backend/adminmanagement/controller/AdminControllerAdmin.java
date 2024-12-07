package com.travelagency.backend.adminmanagement.controller;

import com.travelagency.backend.adminmanagement.model.Admin;
import com.travelagency.backend.adminmanagement.services.AdminServiceAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminControllerAdmin {
    private final AdminServiceAdmin adminService;
    @Autowired
    public AdminControllerAdmin(AdminServiceAdmin adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    //This method creates a new Admin record by accepting the Admin object
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        return ResponseEntity.ok(adminService.saveAdmin(admin));
    }

    @GetMapping("/admins")
    // This method retrieves all Admin records from the database using the AdminService.
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    // This method retrieves a specific Admin record by its ID using the AdminService.
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    // This method deletes the Admin record with the specified ID from the database using the AdminService.
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdminById(id);
        return ResponseEntity.noContent().build();
    }

    /*@PutMapping("/update/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin updatedAdmin) {
        try {
            Admin updated = adminService.updateAdmin(id, updatedAdmin);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }*/
}
