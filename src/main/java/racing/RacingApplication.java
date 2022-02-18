package racing;

import java.util.List;
import racing.domain.Car;
import racing.domain.CarGenerator;
import racing.domain.Judgement;
import racing.domain.Racing;
import racing.domain.RacingResult;
import racing.domain.RandomMoveRule;
import racing.domain.Round;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingApplication {

    public static void main(String[] args) {
        List<Car> cars = CarGenerator.createCars(InputView.getCarNames(), new RandomMoveRule());
        Round round = new Round(InputView.getTotalRoundNumber());

        Racing racing = new Racing(cars, round);
        racing.race();
        RacingResult result = racing.getResult();

        Judgement judgement = new Judgement(result.getLastRoundResult());
        ResultView.printResultAndWinners(result.getRacingResult(), judgement.judgeWinner());
    }
}
