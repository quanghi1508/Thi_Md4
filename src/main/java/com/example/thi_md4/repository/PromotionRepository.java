package com.example.thi_md4.repository;

import com.example.thi_md4.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    Promotion findPromotionById(Long promotionId);
    Promotion findPromotionByTitle (String promotionTitle);
}
