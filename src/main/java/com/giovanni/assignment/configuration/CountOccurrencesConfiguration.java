package com.giovanni.assignment.configuration;

import com.giovanni.assignment.check.CountOccurrences;
import com.giovanni.assignment.check.CountOccurrencesO_N;
import com.giovanni.assignment.generatorList.LargeListGenerator;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountOccurrencesConfiguration {

  private static final List<String> arrayCharacters =
      new LargeListGenerator().generateLargeList(500_000);

  @Bean
  public CountOccurrences countOccurrences() {
    return new CountOccurrences(arrayCharacters);
  }

  @Bean
  public CountOccurrencesO_N countOccurrencesO_N() {
    return new CountOccurrencesO_N(arrayCharacters);
  }
}
