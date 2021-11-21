package study.racingcar.model;

import study.racingcar.strategy.MoveStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void startRound(MoveStrategy moveStrategy){
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public List<Car> getResult(){
        return cars;
    }

    public List<Car> getWinner() {
        return getWinners(maxPosition());
    }

    private int maxPosition() {
        int maxPosition = 0;
        for(Car car : cars){
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    private List<Car> getWinners(int maxPosition) {
        List<Car> winners = cars.stream()
                .filter(car -> car.isWinnerPosition(maxPosition))
                .collect(Collectors.toList());
        return winners;
    }


}
