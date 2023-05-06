package study;

import study.carrace.CarRace;
import study.carrace.CarRaceImpl;
import study.util.InputImpl;
import study.util.RandomizerImpl;
import study.util.ResultImpl;
import study.view.InputView;
import study.view.OutputView;

public class Main {

  public static void main(String[] args) {
    CarRace carRace = new CarRaceImpl(new RandomizerImpl());
    carRace.run(new InputView(new InputImpl(), new InputImpl()), new OutputView(new ResultImpl()));
  }
}
