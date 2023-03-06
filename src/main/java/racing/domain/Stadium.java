package racing.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Stadium {
    public final List<Car> cars;
    public final int round;
    private final StadiumMoveOption stadiumMoveOption;

    // 이름리스트를 초기값으로 받는 버전
    public Stadium(String names, int round, StadiumMoveOption stadiumMoveOption){
        this.cars = initCars(names);
        this.round = round;
        this.stadiumMoveOption = stadiumMoveOption;
    }

    // 차 리스트를 초기로 받는 버전
    public Stadium(List<Car> cars, int round, StadiumMoveOption stadiumMoveOption){
        this.cars = cars;
        this.round = round;
        this.stadiumMoveOption = stadiumMoveOption;
    }

    public List<Car> initCars(String inputCarNames){
        String[] names = inputCarNames.split(",");

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }

        return cars;
    }

    public List<Car> racingCars(){
        for(Car car : cars){
            car.move(stadiumMoveOption.getValue());
        }

        return cars;
    }

    public List<Car> getWinner() {
        final int max = getMaxCarPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == max)
                .collect(Collectors.toList());
    }

    public int getMaxCarPosition() {
        return cars.stream()
                .mapToInt(x -> x.getPosition())
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
