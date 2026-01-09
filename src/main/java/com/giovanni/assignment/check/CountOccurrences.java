package com.giovanni.assignment.check;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CountOccurrences {
  private final List<String> arrayCharacters;

  public Result checkOccurrences() {
    long startTime = System.nanoTime();

    boolean hasDuplicate = false;

    Collections.sort(arrayCharacters);
    hasDuplicate =
        IntStream.range(1, arrayCharacters.size())
            .anyMatch(i -> arrayCharacters.get(i).equals(arrayCharacters.get(i - 1)));

    long endTime = System.nanoTime();
    long durationNs = endTime - startTime;

    return new Result(hasDuplicate, durationNs);
  }

  public static class Result {
    public final boolean hasDuplicate;
    public final long durationNs;

    public Result(boolean hasDuplicate, long durationNs) {
      this.hasDuplicate = hasDuplicate;
      this.durationNs = durationNs;
    }
  }
}
