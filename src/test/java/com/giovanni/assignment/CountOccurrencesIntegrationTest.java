package com.giovanni.assignment;

import static org.junit.jupiter.api.Assertions.*;

import com.giovanni.assignment.check.CountOccurrences;
import com.giovanni.assignment.check.CountOccurrencesO_N;
import com.giovanni.assignment.generatorList.LargeListGenerator;
import com.giovanni.assignment.service.CountOccurrencesService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("local")
@SpringBootTest(classes = AssignmentApplication.class)
class CountOccurrencesIntegrationTest {

  @Autowired private CountOccurrencesService countService;

  @Autowired private LargeListGenerator largeListGenerator;

  @Test
  void testBeansInjected() {
    assertNotNull(countService, "CountOccurrencesService bean should be injected");
    assertNotNull(
        countService.hasDuplicates(), "CountOccurrences bean should be injected via service");
    assertNotNull(
        countService.hasDuplicatesO_N(), "CountOccurrencesO_N bean should be injected via service");
    assertNotNull(largeListGenerator, "LargeListGenerator bean should be injected");
  }

  @Test
  void testDuplicatesWithSpringBeans() {
    CountOccurrencesO_N.Result resultO_N = countService.hasDuplicatesO_N();
    CountOccurrences.Result resultONLogN = countService.hasDuplicates();

    assertTrue(resultO_N.hasDuplicate, "O(n) should detect duplicates via service");
    assertTrue(resultONLogN.hasDuplicate, "O(n log n) should detect duplicates via service");
  }

  @Test
  void testDuplicatesWithLargeList() {
    List<String> largeList = largeListGenerator.generateLargeList(500_000);

    CountOccurrences largeONLogN = new CountOccurrences(largeList);
    CountOccurrencesO_N largeO_N = new CountOccurrencesO_N(largeList);

    long startNs = System.nanoTime();
    boolean resultO_N = largeO_N.checkOccurrences().hasDuplicate;
    long durationO_N = System.nanoTime() - startNs;

    startNs = System.nanoTime();
    boolean resultONLogN = largeONLogN.checkOccurrences().hasDuplicate;
    long durationONLogN = System.nanoTime() - startNs;

    System.out.println("Large list results:");
    System.out.println("O(n) result: " + resultO_N + ", time(ns): " + durationO_N);
    System.out.println("O(n log n) result: " + resultONLogN + ", time(ns): " + durationONLogN);

    assertTrue(resultO_N, "O(n) should detect duplicates in large list");
    assertTrue(resultONLogN, "O(n log n) should detect duplicates in large list");
  }
}
