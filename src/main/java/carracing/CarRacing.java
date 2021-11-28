package carracing;

import carracing.cars.CarName;
import carracing.cars.RandomStepForwardStrategy;
import carracing.rounds.Rounds;
import carracing.view.InputView;
import carracing.view.ResultView;

import java.util.List;

public class CarRacing {
    public static void main(String[] args) {
        List<CarName> carNames = InputView.inputCarNames();
        int round = InputView.inputRound();
        RandomStepForwardStrategy randomStepForwardStrategy = new RandomStepForwardStrategy();

        CarRace carRace = new CarRace(carNames, round, randomStepForwardStrategy);
        Rounds rounds = carRace.race();

        InputView.print("실행 결과");
        ResultView.printRounds(rounds.getRounds());
        ResultView.printWinner(rounds.getWinners());
    }
}
