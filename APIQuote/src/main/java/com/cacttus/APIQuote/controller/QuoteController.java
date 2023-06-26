package com.cacttus.APIQuote.controller;

import com.cacttus.APIQuote.service.QuoteService;
import com.cacttus.APIQuote.user.Quote;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quote")
@CrossOrigin()
@RequiredArgsConstructor
public class QuoteController {

    private final QuoteService quoteService;
    @GetMapping("/getAllQuote")
    public ResponseEntity<List <Quote>> getAllQuote(){
        return ResponseEntity.ok(quoteService.getAllQuote());
    }

    @PostMapping("/create")
    public ResponseEntity<Quote> createQuote(
            @RequestBody Quote quote
    ){
        return ResponseEntity.ok(quoteService.createQuote(quote));
    }
}
