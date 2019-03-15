package racingcar;

import java.util.List;

public class RacingMain {
    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();
        RacingResult result = new RacingResult();
        String[] names = result.splitCarName(carNames);
        List<RacingCar> resultCarNames = result.createRacingCar(names);
        RacingGame racingGame = new RacingGame(resultCarNames, tryNo);
        result.executeBattle(racingGame.getTryCnt(), racingGame.getRacingCars());
        result.executeWinner(racingGame.getRacingCars());
    }
}
