package com.store.backend.service;

import com.store.backend.model.Product;
import com.store.backend.model.Review;
import com.store.backend.model.User;
import com.store.backend.repository.ProductRepository;
import com.store.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public Product updateRating(String productId, Integer addRating) {
        Product repoProduct = productRepository.findById(productId).isEmpty() ? null :
                productRepository.findById(productId).get();

        assert repoProduct != null;
        Double rating = repoProduct.getRating() * repoProduct.getNrReview() + addRating;
        repoProduct.setNrReview(repoProduct.getNrReview() + 1);
        rating /= repoProduct.getNrReview();
        repoProduct.setRating(rating);
        /*     TODO:*/
        //        repoProduct.setDescription(description);
        return productRepository.save(repoProduct);
    }

    public User addReview(String userId, String productId, Integer rating) {
        User user = userRepository.findById(userId).isEmpty() ? null :
                userRepository.findById(userId).get();
        assert user != null;

        Product reviewedProduct = productRepository.findById(productId).isEmpty() ? null :
                productRepository.findById(productId).get();
        assert  reviewedProduct != null;

        user.getReviews().add(new Review(reviewedProduct.getId(), rating));

        return userRepository.save(user);
    }
}