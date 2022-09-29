package com.nirajkumar.InventoryManagement.Repository;

import com.nirajkumar.InventoryManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
