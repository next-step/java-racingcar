package com.cspark.nextstep.step3;

import static com.cspark.nextstep.step3.domain.DriverUtil.makeDrivers;

import com.cspark.nextstep.step3.domain.Dice;
import com.cspark.nextstep.step3.domain.Driver;
import com.cspark.nextstep.step3.domain.Round;
import com.cspark.nextstep.step3.domain.RoundIterable;
import com.cspark.nextstep.step3.ui.InputView;
import com.cspark.nextstep.step3.ui.OutputView;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class InteractiveScanner {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Input View
    InputView inputView = new InputView(scanner);
    String[] driverNames = inputView.nameScript();
    int roundCount = inputView.roundScript();
    inputView.printDashboard(driverNames.length, roundCount);

    // 레이싱 경주
    Function<Dice, Boolean> rule = (d) -> d.cast() > 3;
    RoundIterable rounds = new RoundIterable(roundCount, makeDrivers(driverNames, rule));
    Dice dice = new Dice(0, 10);

    for (Round round : rounds) {
      List<Driver> race = round.race(dice);
      OutputView.displayLap(race);  // 누적 전진,후진 이력
    }

    // 우승자
    OutputView.displayWinner(rounds.podium());
  }
}
