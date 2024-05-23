package com.lostandfound.LostAndFound.service;

import com.lostandfound.LostAndFound.model.ReportedItem;
import com.lostandfound.LostAndFound.repository.ReportedItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportedItemService {
    private final ReportedItemRepository reportedItemRepository;

    public ReportedItemService(ReportedItemRepository reportedItemRepository) {
        this.reportedItemRepository = reportedItemRepository;
    }

    public ReportedItem createReportedItem(ReportedItem reportedItem){
        return reportedItemRepository.save(reportedItem);
    }

    public ReportedItem getReportedItem(Long Id){
        Optional<ReportedItem> reportedItem = reportedItemRepository.findById(Id);
        return reportedItem.orElse(null);
    }

    public ReportedItem updateReportedItem(Long Id, ReportedItem reportedItem){
        Optional<ReportedItem> existingReportedItem = reportedItemRepository.findById(Id);
        if(existingReportedItem.isPresent()){
            ReportedItem existing = existingReportedItem.get();
            existing.setName(reportedItem.getName());
            existing.setDescription(reportedItem.getDescription());
            existing.setLostDate(reportedItem.getLostDate());
            existing.setStatus(reportedItem.getStatus());
            existing.setLostLocation(reportedItem.getLostLocation());

            reportedItemRepository.save(existing);
            return existing;
        }
        return null;
    }

    public void deleteReportedItem(Long Id){
        reportedItemRepository.deleteById(Id);
    }

    public List<ReportedItem> getAllReportedItems(){
        return reportedItemRepository.findAll();
    }
}
