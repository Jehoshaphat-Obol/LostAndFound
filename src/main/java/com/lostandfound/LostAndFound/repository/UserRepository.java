package com.lostandfound.LostAndFound.repository;

import com.lostandfound.LostAndFound.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    // You can define custom query methods here if needed
}
