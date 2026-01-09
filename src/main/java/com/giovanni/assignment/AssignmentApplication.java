package com.giovanni.assignment;

import com.giovanni.assignment.service.CountOccurrencesService;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssignmentApplication implements CommandLineRunner {

  private final CountOccurrencesService countService;

  public AssignmentApplication(CountOccurrencesService countService) {
    this.countService = countService;
  }

  public static void main(String[] args) {
    SpringApplication.run(AssignmentApplication.class, args);
  }

  @Override
  public void run(String @NonNull ... args) {

    var result1 = countService.hasDuplicatesO_N();
    System.out.println(
        "O(n) result: " + result1.hasDuplicate + ", time(ns): " + result1.durationNs);

    var result2 = countService.hasDuplicates();
    System.out.println(
        "O(n log n) result: " + result2.hasDuplicate + ", time(ns): " + result2.durationNs);
  }
}
