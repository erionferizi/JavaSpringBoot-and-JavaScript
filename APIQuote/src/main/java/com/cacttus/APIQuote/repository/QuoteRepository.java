package com.cacttus.APIQuote.repository;


import com.cacttus.APIQuote.user.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Integer>{

}
