package step4;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private String carNames;
    private int moveCount;
    private List<Car> cars;

    public InputView() {
    }

    public InputView(String carNames, int moveCount) {
        this.carNames = carNames;
        this.moveCount = moveCount;
        setCars();
    }

    public void setCars() {
        cars = createUsers(splitCarName());
    }

    public void validateInput(String carNames) {
        if (carNames == null || "".equals(carNames.trim())) {
            throw new IllegalArgumentException();
        }
    }

    public String[] splitCarName() {
        return carNames.split(",");
    }

    public ArrayList<Car> createUsers(String[] splitCarName) {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < splitCarName.length; i++) {
            addCar(splitCarName[i], cars);
        }
        return cars;
    }

    public void addCar(String carName, List<Car> cars) {
        Car car = new Car(carName, "");
        cars.add(car);
    }

    public int getMoveCount() {
        return moveCount;
    }

    public List<Car> getCars() {
        return cars;
    }

}
