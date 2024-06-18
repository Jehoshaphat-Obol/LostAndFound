package com.lostandfound.LostAndFound.controller;

import com.lostandfound.LostAndFound.model.ReportedItem;
import com.lostandfound.LostAndFound.service.ReportedItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reported")
public class ReportedItemController {

    @Autowired
    private ReportedItemService reportedItemService;

    @GetMapping
    public List<ReportedItem> getAllReportedItems() {
        return reportedItemService.getAllReportedItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportedItem> getReportedItemById(@PathVariable Long id) {
        Optional<ReportedItem> reportedItem = reportedItemService.getReportedItemById(id);
        return reportedItem.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/postdata")
    public ReportedItem createReportedItem(@RequestBody ReportedItem reportedItem) {
        return reportedItemService.saveReportedItem(reportedItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReportedItem> updateReportedItem(@PathVariable Long id, @RequestBody ReportedItem reportedItemDetails) {
        Optional<ReportedItem> optionalReportedItem = reportedItemService.getReportedItemById(id);
        if (optionalReportedItem.isPresent()) {
            ReportedItem reportedItem = optionalReportedItem.get();
            reportedItem.setName(reportedItemDetails.getName());
            reportedItem.setDescription(reportedItemDetails.getDescription());
            reportedItem.setLostDate(reportedItemDetails.getLostDate());
            reportedItem.setLostLocation(reportedItemDetails.getLostLocation());
            reportedItem.setPhoneNumber(reportedItemDetails.getPhoneNumber());
            reportedItem.setEmail(reportedItemDetails.getEmail());
            reportedItem.setStatus(reportedItemDetails.getStatus());
            ReportedItem updatedReportedItem = reportedItemService.saveReportedItem(reportedItem);
            return ResponseEntity.ok(updatedReportedItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReportedItem(@PathVariable Long id) {
        Optional<ReportedItem> optionalReportedItem = reportedItemService.getReportedItemById(id);
        if (optionalReportedItem.isPresent()) {
            reportedItemService.deleteReportedItem(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
