package racinggame;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int currentRound = 0;
    private CarLists carLists;
    private RacingGameParameters racingGameParameters;
    private List<List<Integer>> gameResult;

    public RacingGame(RacingGameParameters racingGameParameters) {
        this.racingGameParameters = racingGameParameters;
        this.carLists = new CarLists(racingGameParameters.getCarQuantity());
        this.saveCurrentResult();
    }

    private List<Car> createCars(int carQuantity) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carQuantity; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    private void playRound() {
        this.currentRound += 1;
        for (Car car : this.carLists.getCarList()) {
            car.move();
        }
    }

    public void playFullRound() {
        while (this.currentRound < this.racingGameParameters.getGameRound()) {
            playRound();
            saveCurrentResult();
        }
    }

    private void saveCurrentResult() {
        List<Integer> carPositionList = new ArrayList<>();
        for (Car car : this.carLists.getCarList()) {
            carPositionList.add(car.getPosition());
        }
        this.gameResult.add(carPositionList);
    }

    public List<List<Integer>> getGameResult() {
        return gameResult;
    }
}
