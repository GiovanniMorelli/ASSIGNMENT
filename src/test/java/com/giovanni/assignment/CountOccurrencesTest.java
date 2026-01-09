package com.giovanni.assignment;

import static org.junit.jupiter.api.Assertions.*;

import com.giovanni.assignment.check.CountOccurrences;
import com.giovanni.assignment.check.CountOccurrencesO_N;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CountOccurrencesTest {

  private CountOccurrences countOccurrences;
  private CountOccurrencesO_N countOccurrencesO_N;

  @BeforeEach
  public void setUp() {
    List<String> sampleList = Arrays.asList("a", "b", "c", "a", "d", "e");
    countOccurrences = new CountOccurrences(sampleList);
    countOccurrencesO_N = new CountOccurrencesO_N(sampleList);
  }

  @Test
  public void testDuplicatesO_N() {
    var result = countOccurrencesO_N.checkOccurrences();
    assertTrue(result.hasDuplicate, "O(n) should detect duplicates");
  }

  @Test
  public void testDuplicatesONLogN() {
    var result = countOccurrences.checkOccurrences();
    assertTrue(result.hasDuplicate, "O(n log n) should detect duplicates");
  }

  @Test
  public void testNoDuplicates() {
    List<String> noDupList = Arrays.asList("x", "y", "z");
    CountOccurrences noDupONLogN = new CountOccurrences(noDupList);
    CountOccurrencesO_N noDupO_N = new CountOccurrencesO_N(noDupList);

    assertFalse(
        noDupONLogN.checkOccurrences().hasDuplicate, "O(n log n) should detect no duplicates");
    assertFalse(noDupO_N.checkOccurrences().hasDuplicate, "O(n) should detect no duplicates");
  }
}
