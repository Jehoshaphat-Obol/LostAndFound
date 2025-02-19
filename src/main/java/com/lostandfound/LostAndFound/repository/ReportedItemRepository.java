package com.lostandfound.LostAndFound.repository;

import com.lostandfound.LostAndFound.model.ReportedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportedItemRepository extends JpaRepository<ReportedItem, Long> {
    // You can define custom query methods here if needed
}
