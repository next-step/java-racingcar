package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;
    private int[] carPositions;
    private int maxPosition = 0;


    public Cars(String[] carNameList) {
        this(carNameList, new int[carNameList.length]);
    }

    public Cars(String[] carNameList, int[] positionList) {

        cars = new ArrayList<>();
        carPositions = new int[carNameList.length];

        for (int i = 0; i < carNameList.length; i++) {
            this.cars.add(new Car(carNameList[i], positionList[i]));
            carPositions[i] = positionList[i];
        }
    }

    public void playGame(Dice dice) {

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            car.move(dice.makeNumber());
            carPositions[i] = car.getPosition();
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

        for (Integer position : carPositions) {
            maxPosition = Integer.max(maxPosition, position);
        }

    }

    private List<String> makeWinnerList(List<Car> carList) {
        return carList.stream().filter(car -> car.isSamePosition(maxPosition))
                .map(car -> car.getCarName()).collect(Collectors.toList());
    }
}
