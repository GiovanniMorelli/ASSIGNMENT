package com.giovanni.assignment.assignment.check;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CountOccurrencesO_N {
  private final List<String> arrayCharacters;

  public Result checkOccurrences() {
    long startTime = System.nanoTime();

    Set<String> seen = new HashSet<>();
    boolean hasDuplicate = false;

    for (String c : arrayCharacters) {
      if (!seen.add(c)) {
        hasDuplicate = true;
        break;
      }
    }

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
