package study.race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {

  private static final int BOUNDED_VALUE = 5;
  Random random = new Random();
  private List<String> raceResult = new ArrayList<>();

  public void progress() {
    int randomNumber = random.nextInt(10);

    if (randomNumber < BOUNDED_VALUE) {
      this.go();
      return;
    }

    this.stop();
  }

  public String currentRace(int end) {
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < end; i++) {
      if ("go".equals(raceResult.get(i))) {
        stringBuffer.append("-");
      }
    }

    return stringBuffer.toString();
  }

  private void go() {
    this.raceResult.add("go");
  }

  private void stop() {
    this.raceResult.add("stop");
  }
}
