package racingcar;

import racingcar.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int tryCnt;
    private int winnerCoordinate = 0;
    private List<RacingCar> racingCars;

    public RacingGame(String[] carNames, int tryCnt) {
        this.racingCars = new ArrayList<>();
        this.tryCnt = tryCnt;
        createRacingCar(carNames);
    }

    public void createRacingCar(String[] carNames) {
        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
    }

    public int getTryCnt() {
        return tryCnt;
    }

    public void setRacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public int getWinnerCoordinate() {
        for (RacingCar car : racingCars)
            winnerCoordinate = car.findMaxCoordinate(winnerCoordinate);
        return winnerCoordinate;
    }

    public String getWinnerName() {
        StringBuilder winnerNames = new StringBuilder();
        for (RacingCar car : racingCars){
            if(car.isMaxCoordinate(winnerCoordinate)){
                winnerNames.append(car.getName()).append(Constant.FORMAT_COMMA);
            }
        }
        return winnerNames.toString();
    }
}
