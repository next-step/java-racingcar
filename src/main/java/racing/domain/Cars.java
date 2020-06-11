package racing.domain;

import racing.utils.Dice;
import racing.utils.Valid;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;
    private int maxPosition = 0;

    public Cars(String[] carNames) {
        this(carNames, new int[carNames.length]);
    }

    public Cars(String[] carNames, int[] positions) {

        Valid.sizeCompare(carNames, positions);
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

        Map<String,Integer> returnCars =new LinkedHashMap<>();

        for (Car car: this.cars) {
            returnCars.put(car.getCarName(),car.getPosition());
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
}
