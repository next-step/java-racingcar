package racing.domain;

import racing.utils.Dice;
import racing.utils.InputValid;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;
    private int maxPosition = 0;

    public Cars(String[] carNames) {
        this(carNames, new int[carNames.length]);
    }

    public Cars(String[] carNames, int[] positions) {

        sizeCompare(carNames, positions);
        cars = new ArrayList<>();

        for (int i = 0; i < carNames.length; i++) {
            this.cars.add(new Car(carNames[i], positions[i]));
        }
    }

    public void playGame(Dice dice) {

        for (Car car : cars) {
            car.move(dice.makeNumber());
        }

    }

    public Map getCars() {

        Map<String, Integer> returnCars = new LinkedHashMap<>();

        for (Car car : this.cars) {
            returnCars.put(car.getCarName(), car.getPosition());
        }

        return returnCars;
    }

    public List<String> getWinner() {

        setMaxPostion();

        return makeWinnerList(cars);
    }

    private void setMaxPostion() {
        maxPosition = Collections.max(cars).getPosition();
    }

    private List<String> makeWinnerList(List<Car> inputCars) {
        return inputCars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(car -> car.getCarName())
                .collect(Collectors.toList());
    }

    private void sizeCompare(String[] carNames, int[] positions) {
        if (positions == null) {
            throw new IllegalArgumentException("position이 null입니다.");
        }

        if (carNames == null) {
            throw new IllegalArgumentException("carName이 null입니다.");
        }

        if (carNames.length != positions.length) {
            throw new IllegalArgumentException("이름 사이즈와 위치 사이즈가 일치 하지 않습니다.");
        }
    }
}
