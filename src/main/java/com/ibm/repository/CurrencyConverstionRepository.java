package com.ibm.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.model.CurrencyConverstionModel;

@Repository
public interface CurrencyConverstionRepository extends JpaRepository<CurrencyConverstionModel, UUID> {


	CurrencyConverstionModel findByCountryCode(String countryCode);

}
