package study.carrace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import study.car.Car;
import study.util.Randomizer;

public class Race {

  private static final int BOUNDED_VALUE = 4;
  private static final int GO = 1;
  private static final int STOP = 0;
  private List<Distance> distances = new ArrayList<>();
  private final Randomizer randomizer;
  private final Car car;

  public Race(Randomizer randomizer, Car car) {
    this.randomizer = randomizer;
    this.car = car;
  }

  public void progress() {
    int randomNumber = randomizer.getRandomValue(10);

    if (randomNumber >= BOUNDED_VALUE) {
      this.go();
      return;
    }

    this.stop();
  }

  public String currentRace(int end) {
    int currentDistance = this.cumulativeSum(end);
    return this.car.getName() + " : " + String.join("", Collections.nCopies(currentDistance, "-"));
  }

  private void go() {
    distances.add(new Distance(GO));
  }

  private void stop() {
    distances.add(new Distance(STOP));
  }

  private int cumulativeSum(int number) {
    if(this.distances.size() < number) {
      throw new ArrayIndexOutOfBoundsException();
    }

    int result = 0;
    for(int i=0; i<number;i++) {
      result += this.distances.get(i).getValue();
    }

    return result;
  }
}
