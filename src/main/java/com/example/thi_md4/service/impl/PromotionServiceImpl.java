package com.example.thi_md4.service.impl;

import com.example.thi_md4.dto.PromotionDto;
import com.example.thi_md4.entity.Promotion;
import com.example.thi_md4.repository.PromotionRepository;
import com.example.thi_md4.service.PromotionService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PromotionServiceImpl implements PromotionService {
    private final PromotionRepository promotionRepository;
    private final ModelMapper modelMapper;

    public PromotionServiceImpl(PromotionRepository promotionRepository,
                                ModelMapper modelMapper) {
        this.promotionRepository = promotionRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<PromotionDto> getPromotions() {
        List<Promotion> promotions = promotionRepository.findAll();
        return promotions
                .stream()
                .map(promotion -> modelMapper.map(promotion,PromotionDto.class))
        .toList();
    }

    @Override
    public PromotionDto addPromotion(PromotionDto promotionDto) {
        Promotion existingPromotion = promotionRepository.findPromotionByTitle(promotionDto.getTitle());
        if (Optional.ofNullable(existingPromotion).isPresent()) {
            return null;
        } else {
            Promotion newPromotion = modelMapper.map(promotionDto, Promotion.class);
            Promotion savedPromotion = promotionRepository.save(newPromotion);
            return modelMapper.map(savedPromotion, PromotionDto.class);
        }
    }

    @Override
    public PromotionDto editPromotion(Long id, PromotionDto promotionDto) {
        return null;
    }

    @Override
    public boolean removePromotion(Long id) {
        return false;
    }
}
