package racing.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Stadium {
    private final List<Car> cars;
    private final int round;
    private final StadiumMoveOption stadiumMoveOption;

    // 이름리스트를 초기값으로 받는 버전
    public Stadium(String names, int round){
        this(initCars(names),
                round,
                new RandomStadiumMoveOptionImpl());
    }

    // 차 리스트를 초기로 받는 버전
    public Stadium(List<Car> cars, int round, StadiumMoveOption stadiumMoveOption){
        this.cars = cars;
        this.round = round;
        this.stadiumMoveOption = new RandomStadiumMoveOptionImpl();
    }

    private static List<Car> initCars(String inputCarNames){
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
        final int maxPosition = getMaxCarPosition();

        return getSpecificLocationCars(maxPosition);
    }

    public int getMaxCarPosition() {
        return cars.stream()
                .mapToInt(x -> x.getPosition())
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Car> getSpecificLocationCars(int position) {
        return cars.stream()
                .filter(car -> car.getPosition() == position)
                .collect(Collectors.toList());
    }
}
