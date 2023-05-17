package com.store.backend.controller;

import com.store.backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @PostMapping
    public void updateProductRating(@RequestBody String userId, @RequestBody String productId, @RequestBody Integer addRating) {
        service.addReview(userId, productId, addRating);
        service.updateRating(productId, addRating);
    }
}