package com.example.thi_md4.controller;

import com.example.thi_md4.dto.PromotionDto;
import com.example.thi_md4.service.PromotionService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/b2c/promotions")
public class PromotionController {
    private final PromotionService promotionService;

    public PromotionController(PromotionService promotionservice) {
        this.promotionService = promotionservice;
    }
    @GetMapping
    public String getPromotions(Model model) {
        List<PromotionDto> promotionDtoList = promotionService.getPromotions();
        model.addAttribute("promotions", promotionDtoList);
        return "/index";
    }
    @PostMapping("/add")
    public ResponseEntity<?> postPromotion(@RequestBody PromotionDto promotionDto) {
        PromotionDto newPromotionDto = promotionService.addPromotion(promotionDto);
        if (Optional.ofNullable(newPromotionDto).isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Existing category!!!");
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(newPromotionDto);
        }
    }
}
