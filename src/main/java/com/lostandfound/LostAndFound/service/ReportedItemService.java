package com.lostandfound.LostAndFound.service;

import com.lostandfound.LostAndFound.model.ReportedItem;
import com.lostandfound.LostAndFound.repository.ReportedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportedItemService {

    @Autowired
    private ReportedItemRepository reportedItemRepository;

    public List<ReportedItem> getAllReportedItems() {
        return reportedItemRepository.findAll();
    }

    public Optional<ReportedItem> getReportedItemById(Long itemId) {
        return reportedItemRepository.findById(itemId);
    }

    public ReportedItem saveReportedItem(ReportedItem reportedItem) {
        return reportedItemRepository.save(reportedItem);
    }

    public void deleteReportedItem(Long itemId) {
        reportedItemRepository.deleteById(itemId);
    }
}
