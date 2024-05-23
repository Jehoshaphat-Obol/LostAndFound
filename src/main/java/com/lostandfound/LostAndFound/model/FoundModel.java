package com.lostandfound.LostAndFound.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class FoundModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    private  String name;
    private  String description;
    private  String foundDate;
    private  String foundLocation;
    private  int status;

    public Long getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getFoundDate() {
        return foundDate;
    }

    public String getFoundLocation() {
        return foundLocation;
    }

    public int getStatus() {
        return status;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFoundDate(String foundDate) {
        this.foundDate = foundDate;
    }

    public void setFoundLocation(String foundLocation) {
        this.foundLocation = foundLocation;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
