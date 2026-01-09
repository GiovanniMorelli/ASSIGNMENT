package com.giovanni.assignment.assignment.generatorList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LargeListGenerator {

  public List<String> generateLargeList(int size) {
    Random random = new Random();
    List<String> list = new ArrayList<>(size);

    for (int i = 0; i < size; i++) {
      char c1 = (char) ('a' + random.nextInt(26));
      char c2 = (char) ('a' + random.nextInt(26));
      list.add("" + c1 + c2);
    }

    return list;
  }
}
