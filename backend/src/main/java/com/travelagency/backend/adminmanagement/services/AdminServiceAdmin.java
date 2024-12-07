package com.travelagency.backend.adminmanagement.services;

import com.travelagency.backend.adminmanagement.model.Admin;
import com.travelagency.backend.adminmanagement.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceAdmin {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceAdmin(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    // Create or Update Admin
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Get all Admins
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Get Admin by ID
    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    // Delete Admin by ID
    public void deleteAdminById(Long id) {
        adminRepository.deleteById(id);
    }

    // Find Admin by Email (if needed for login/authentication)
    public Optional<Admin> findAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

   /* public Admin updateAdmin(Long id, Admin updatedAdmin) {
        Admin existingAdmin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));

        // Update the fields only if the updatedAdmin has new non-null values
        if (updatedAdmin.getName() != null && !updatedAdmin.getName().isEmpty()) {
            existingAdmin.setName(updatedAdmin.getName());
        }
        if (updatedAdmin.getEmail() != null && !updatedAdmin.getEmail().isEmpty()) {
            existingAdmin.setEmail(updatedAdmin.getEmail());
        }
        if (updatedAdmin.getPassword() != null && !updatedAdmin.getPassword().isEmpty()) {
            existingAdmin.setPassword(updatedAdmin.getPassword());
        }

        // Save the updated admin and return it
        return adminRepository.save(existingAdmin);
    }*/
}
