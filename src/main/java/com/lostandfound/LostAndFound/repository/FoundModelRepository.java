package com.lostandfound.LostAndFound.repository;

import com.lostandfound.LostAndFound.model.FoundModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoundModelRepository extends JpaRepository<FoundModel, Long> {

}
