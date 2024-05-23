package com.lostandfound.LostAndFound.repository;

import com.lostandfound.LostAndFound.model.ReportedItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportedItemRepository extends JpaRepository<ReportedItem, Long> {
}
