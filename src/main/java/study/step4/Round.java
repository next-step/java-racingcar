package study.step4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Round {
    private final static String CAR_ILLEGALEXCEPTION_MESSAGE = "자동차는 1개 이상 들어가야 합니다.";

    private List<Car> cars;

    public Round(List<Car> cars) {
        this.cars = cars;
    }

    public Round(String [] carNames) {
        validateCarNames(carNames);
        this.cars = convertToList(carNames);
    }

    private List<Car> convertToList(String[] carNames) {
        return Stream.of(carNames)
                .map(value-> new Car(value))
                .collect(Collectors.toList());
    }

    private void validateCarNames(String[] carNames) {
        if (Objects.isNull(carNames) || carNames.length == 0){
            throw new IllegalArgumentException(CAR_ILLEGALEXCEPTION_MESSAGE);
        }
    }

    public List<Car> getCars(){
        return new ArrayList<>(cars);
    }

    public Round carsRun(CarMoveCondition moveCondition) {
        List<Car> arrivedCars = new ArrayList<>();
        for (Car car : cars){
            arrivedCars.add(car.move(moveCondition));
        }
        return new Round(arrivedCars);
    }

    public int findMaxCarPostion(){
        return cars.stream()
                .mapToInt(Car:: getCarPosition)
                .max()
                .getAsInt();
    }

    public List<String> decideChampion(){
        int lastMaxPosition = findMaxCarPostion();
        return new ArrayList<>(
                cars.stream()
                    .filter(car -> car.isChampionsPosition(lastMaxPosition))
                    .map(car -> car.getCarName())
                    .collect(Collectors.toList()));
    }
}
