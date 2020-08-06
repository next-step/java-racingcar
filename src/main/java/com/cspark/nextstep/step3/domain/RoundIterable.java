package com.cspark.nextstep.step3.domain;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class RoundIterable implements Iterable<Round> {

  private int roundCount;
  private final List<Driver> drivers;

  public RoundIterable(int roundCount, List<Driver> drivers) {
    this.roundCount = roundCount;
    this.drivers = drivers;
  }

  @Override
  public Iterator<Round> iterator() {
    return new RoundIterator(roundCount, drivers);
  }

  public List<Driver> podium() {
    return drivers.stream()
        .collect(Collectors.groupingBy(Driver::forwardCount))
        .entrySet().stream()
        .reduce((a, b) -> a.getKey() > b.getKey() ? a : b)
        .map(Entry::getValue)
        .get();
  }

  private static class RoundIterator implements Iterator<Round> {

    private final int roundCount;
    private final List<Driver> drivers;
    private int current = 0;

    public RoundIterator(int roundCount, List<Driver> drivers) {
      this.roundCount = roundCount;
      this.drivers = drivers;
    }

    @Override
    public boolean hasNext() {
      return current < roundCount;
    }

    @Override
    public Round next() {
      current++;
      return new Round(drivers);
    }
  }
}