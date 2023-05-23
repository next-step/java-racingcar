package study.step4;

import study.step4.domain.Car;
import study.step4.move.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Car> carList = new ArrayList<>();
    private final MoveStrategy moveStrategy;

    public RacingGame(String[] carNames, MoveStrategy moveStrategy){
        this.moveStrategy = moveStrategy;
        for (String carName : carNames) {
            this.carList.add(new Car(carName));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getWinnerList() {
        List<Car> winnerList = new ArrayList<>();
        int maxPosition = -1;

        for (Car car : carList) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winnerList.clear();
                winnerList.add(car);
            } else if (car.getPosition() == maxPosition) {
                winnerList.add(car);
            }
        }
        return winnerList;
    }

    public void play() {
        for (Car car : carList) {
                car.move(moveStrategy);
        }
    }
}
