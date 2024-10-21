package com.example.thi_md4.service;

import com.example.thi_md4.dto.PromotionDto;
import java.util.List;

public interface PromotionService {
    List<PromotionDto> getPromotions();
    PromotionDto addPromotion(PromotionDto promotionDto);
    PromotionDto editPromotion(Long id, PromotionDto promotionDto);
    boolean removePromotion(Long id);
}
