package racingcar;

import racingcar.entity.RacingCar;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        List<RacingCar> racingCars = new ArrayList<>();
        String[] carNames = inputView.requestCarNames();
        int tryNumber = inputView.requestTryNumber();
        initializeRacingCars(racingCars, carNames);
        race(racingCars, tryNumber, new RandomMoveStrategy());
        int winnerRecord = findMaxPosition(racingCars);
        List<String> winners = pickWinners(racingCars, winnerRecord);
        ResultView.printWinners(winners);
    }

    public static int findMaxPosition(List<RacingCar> racingCars) {
        int maxPosition = 0;
        for (RacingCar racingCar : racingCars) {
            if(racingCar.getPosition()>maxPosition){
                maxPosition = racingCar.getPosition();
            }
        }
        return maxPosition;
    }

    public static List<String> pickWinners(List<RacingCar> racingCars, int winnerRecord) {
        return racingCars.stream()
                .filter(racingCar -> racingCar.getPosition() == winnerRecord)
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    public static void initializeRacingCars(List<RacingCar> racingCars, String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            racingCars.add(new RacingCar(carNames[i]));
        }
    }

    public static void race(List<RacingCar> racingCars, int tryNumber, MoveStrategy moveStrategy) {
        resultView.printResultFirstLine();
        for (int i = 0; i < tryNumber; i++) {
            raceOneStep(racingCars, moveStrategy);
            resultView.printRacingCarsPosition(racingCars);
        }
    }

    public static void raceOneStep(List<RacingCar> racingCars, MoveStrategy moveStrategy) {
        for (int i = 0; i < racingCars.size(); i++) {
            RacingCar racingCar = racingCars.get(i);
            racingCar.moveIfMovable(moveStrategy);
        }
    }
}
