package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;
    private int maxPosition = 0;

    public Cars(String[] carNames) {
        this(carNames, new int[carNames.length]);
    }

    public Cars(String[] carNames, int[] positions) {

        Valid.positionsNullCheck(positions);
        Valid.carNamesNullCheck(carNames);
        Valid.sizeCompare(carNames, positions);

        cars = new ArrayList<>();

        for (int i = 0; i < carNames.length; i++) {
            this.cars.add(new Car(carNames[i], positions[i]));
        }
    }

    public void playGame(Dice dice) {

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            car.move(dice.makeNumber());
        }

    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<String> getWinner() {

        getMaxPostion();

        return makeWinnerList(cars);
    }

    private void getMaxPostion() {
        maxPosition = Collections.max(cars).getPosition();
    }

    private List<String> makeWinnerList(List<Car> inputCars) {
        return inputCars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(car -> car.getCarName())
                .collect(Collectors.toList());
    }
}
