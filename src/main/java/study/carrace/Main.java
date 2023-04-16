package study.carrace;

import study.input.Input;
import study.input.InputImpl;

public class Main {

  public static void main(String[] args) {
    Input input = new InputImpl();
    CarRace carRace = new CarRaceImpl(input);
    String output = carRace.run();
    System.out.println(output);
  }
}
