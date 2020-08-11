package com.cspark.nextstep.step3.domain;

import java.util.Iterator;
import java.util.List;

public class CarRace implements Iterable<Cars> {

  private final int roundCount;
  private final Cars cars;

  public CarRace(int roundCount, String[] carNames) {
    this.roundCount = roundCount;
    this.cars = new Cars(carNames);
  }

  public List<Scorecard> podium() {
    return cars.podium();
  }

  @Override
  public Iterator<Cars> iterator() {
    return new CarsIterator();
  }

  private class CarsIterator implements Iterator<Cars> {

    private int current = 0;

    @Override
    public boolean hasNext() {
      return current < roundCount;
    }

    @Override
    public Cars next() {
      current++;
      return cars;
    }
  }

}
