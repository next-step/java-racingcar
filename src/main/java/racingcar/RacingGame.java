package racingcar;

import racingcar.utils.Constant;
import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int tryNo;
    private int winnerCoordinate = 0;
    private List<RacingCar> racingCars;

    public RacingGame(String[] carNames, int tryNo) {
        this.racingCars = new ArrayList<>();
        createRacingCar(carNames);
        this.tryNo = tryNo;
    }

    public void createRacingCar(String[] carNames) {
        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName, 0));
        }
    }

    public int getWinnerCoordinate() {
        for (RacingCar car : racingCars)
            winnerCoordinate = car.findMaxCoordinate(winnerCoordinate);
        return winnerCoordinate;
    }

    public String getWinnerName() {
        getWinnerCoordinate();
        StringBuilder winnerNames = new StringBuilder();
        for (RacingCar car : racingCars) {
            if (car.isMaxCoordinate(winnerCoordinate))
                winnerNames.append(car.getName()).append(Constant.FORMAT_COMMA);
        }
        return winnerNames.toString();
    }

    public boolean isEnd() {
        return tryNo == 0;
    }

    public RacingResult race() {
        tryNo--;
        perTryRacing();
        return new RacingResult(racingCars);
    }

    private void perTryRacing() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(RandomUtils.createRandom());
        }
    }
}
