package study.carrace;

import study.view.Input;
import study.view.InputImpl;
import study.util.Randomizer;
import study.util.RandomizerImpl;
import study.view.Result;
import study.view.ResultImpl;

public class Main {

  public static void main(String[] args) {
    Input carInput = new InputImpl();
    Input countInput = new InputImpl();
    Randomizer randomizer = new RandomizerImpl();
    CarRace carRace = new CarRaceImpl(carInput, countInput, randomizer);
    String output = carRace.run();
    Result result = new ResultImpl();
    result.print(output);
  }
}
