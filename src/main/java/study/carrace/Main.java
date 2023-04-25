package study.carrace;

import study.input.Input;
import study.input.InputImpl;
import study.util.Randomizer;
import study.util.RandomizerImpl;

public class Main {

  public static void main(String[] args) {
    Input carInput = new InputImpl();
    Input countInput = new InputImpl();
    Randomizer randomizer = new RandomizerImpl();
    CarRace carRace = new CarRaceImpl(carInput, countInput, randomizer);
    String output = carRace.run();
    System.out.println(output);
  }
}
