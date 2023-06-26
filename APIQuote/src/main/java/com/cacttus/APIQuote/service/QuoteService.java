package com.cacttus.APIQuote.service;

import com.cacttus.APIQuote.repository.QuoteRepository;
import com.cacttus.APIQuote.user.Quote;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuoteService {
    private final QuoteRepository quoteRepository;

    @Scheduled(fixedDelay = 86400000)
    public void generateRandomQuote() {

        String randomQuote = callRandomQuoteApi();
        Quote quote = new Quote();
        quote.setQuote(randomQuote);
        quote.setAuthor("Unknown");
        quoteRepository.save(quote);
        System.out.println("Generated a random quote: " + randomQuote);
    }

    public List<Quote> getAllQuote() {
        return quoteRepository.findAll();
    }
    public Quote createQuote(Quote quote){
        Quote quote1 = new Quote();
        quote1.setQuote(quote.getQuote());
        quote1.setAuthor(quote.getAuthor());
        quoteRepository.save(quote1);
        return quote1;
    }


    private String callRandomQuoteApi() {
        return "This is a random quote.";
    }

}
