package study.carrace;

import study.util.InputImpl;
import study.util.RandomizerImpl;
import study.util.ResultImpl;

public class Main {

  public static void main(String[] args) {
    CarRace carRace = new CarRaceImpl(new InputImpl(), new InputImpl(), new RandomizerImpl(), new ResultImpl());
    carRace.run();
  }
}
