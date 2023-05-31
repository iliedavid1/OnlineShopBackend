package com.store.backend.controller;

import com.store.backend.dtos.ReviewDto;
import com.store.backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @PostMapping
    public void updateProductRating(@RequestBody ReviewDto reviewDto) {
        service.addReview(reviewDto.getUserId(), reviewDto.getProductId(), reviewDto.getAddRating());
        service.updateRating(reviewDto.getProductId(), reviewDto.getAddRating());
    }
}