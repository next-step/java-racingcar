package study.carrace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import study.util.Randomizer;
import study.util.RandomizerImpl;

public class Race {

  private static final int BOUNDED_VALUE = 4;
  private static final int GO = 1;
  private static final int STOP = 0;
  private List<Distance> distances = new ArrayList<>();
  private final Randomizer randomizer;

  public Race(Randomizer randomizer) {
    this.randomizer = randomizer;
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
    return String.join("", Collections.nCopies(currentDistance, "-"));
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
