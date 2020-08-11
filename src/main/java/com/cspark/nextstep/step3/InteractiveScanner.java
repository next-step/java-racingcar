package com.cspark.nextstep.step3;

import com.cspark.nextstep.step3.domain.CarRace;
import com.cspark.nextstep.step3.domain.Cars;
import com.cspark.nextstep.step3.domain.Dice;
import com.cspark.nextstep.step3.domain.RaceRule;
import com.cspark.nextstep.step3.domain.Scorecard;
import com.cspark.nextstep.step3.ui.InputView;
import com.cspark.nextstep.step3.ui.OutputView;
import java.util.List;
import java.util.Scanner;

public class InteractiveScanner {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Input View
    InputView inputView = new InputView(scanner);
    String[] carNames = inputView.nameScript();
    int roundCount = inputView.roundScript();
    inputView.printDashboard(carNames.length, roundCount);

    // 레이싱 경주
    RaceRule raceRule = (d) -> d.cast() > 3;
    Dice dice = new Dice(0, 10);

    CarRace rounds = new CarRace(roundCount, carNames);
    for (Cars cars : rounds) {
      List<Scorecard> scorecards = cars.race(raceRule, dice);
      OutputView.displayLap(scorecards);  // 누적 전진,후진 이력
    }

    // 우승자
    OutputView.displayWinner(rounds.podium());
  }
}
