package com.lostandfound.LostAndFound.controller;

import com.lostandfound.LostAndFound.model.ReportedItem;
import com.lostandfound.LostAndFound.service.ReportedItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/reportedItem")
public class ReportedItemController {
    private final ReportedItemService reportedItemService;

    public ReportedItemController(ReportedItemService reportedItemService) {
        this.reportedItemService = reportedItemService;
    }

    @PostMapping
    public ResponseEntity<ReportedItem> createReportedItem(@RequestBody ReportedItem reportedItem){
        System.out.println(reportedItem);
        ReportedItem newReportedItem = reportedItemService.createReportedItem(reportedItem);
        return new ResponseEntity<>(newReportedItem, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportedItem> getReportedItem(@PathVariable Long id){
        ReportedItem reportedItem = reportedItemService.getReportedItem(id);
        return new ResponseEntity<>(reportedItem, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ReportedItem>> getReportedItems(){
        List<ReportedItem> reportedItems = reportedItemService.getAllReportedItems();
        return new ResponseEntity<>(reportedItems, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReportedItem> updateReportedItem(@PathVariable Long id, @RequestBody ReportedItem reportedItem){
        ReportedItem updatedReportedItem = reportedItemService.updateReportedItem(id, reportedItem);
        return new ResponseEntity<>(updatedReportedItem, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReportedItem> deleteReportedItem(@PathVariable Long id){
        reportedItemService.deleteReportedItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
