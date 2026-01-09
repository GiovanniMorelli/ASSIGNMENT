package com.giovanni.assignment.assignment.service;

import com.giovanni.assignment.assignment.check.CountOccurrences;
import com.giovanni.assignment.assignment.check.CountOccurrencesO_N;
import org.springframework.stereotype.Service;

@Service
public class CountOccurrencesService {

  private final CountOccurrences countOccurrences;
  private final CountOccurrencesO_N countOccurrencesO_N;

  public CountOccurrencesService(
      CountOccurrences countOccurrences, CountOccurrencesO_N countOccurrencesON) {
    this.countOccurrences = countOccurrences;
    countOccurrencesO_N = countOccurrencesON;
  }

  public CountOccurrences.Result hasDuplicates() {
    return countOccurrences.checkOccurrences();
  }

  public CountOccurrencesO_N.Result hasDuplicatesO_N() {
    return countOccurrencesO_N.checkOccurrences();
  }
}
