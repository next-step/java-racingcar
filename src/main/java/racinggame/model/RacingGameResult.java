package racinggame.model;

import java.util.List;
import java.util.OptionalInt;

import static java.util.stream.Collectors.toList;

public class RacingGameResult {
    private List<Car> cars;

    public RacingGameResult(List<Car> cars) {
        this.cars = cars;
    }

    /**
     * 레이싱 경기 우승자 가져오기
     * @return
     */
    public List<String> getWinner() {
        int maxPostion = getMaxPositon(cars).getAsInt();
        return cars.stream().filter(car -> car.isSamePosition(maxPostion)).map(Car::getName).collect(toList());
    }

    /**
     * 포지션 최대 값 가져오기
     * @param carList
     * @return
     */
    public OptionalInt getMaxPositon(List<Car> carList) {
        return carList.stream().mapToInt(Car::getPosition).max();
    }

}
