package racingcar4.model;

import java.util.*;

public class RacingGame {
    private static final int NAME_LENGTH_MAXIMUM = 5;
    private final List<Car> cars;

    public RacingGame(String nameOfCars) {
        String[] nameOfCarsList = splitNames(nameOfCars);
        nameOfCarsList = removeOverlap(nameOfCarsList);
        this.cars = new ArrayList<>(nameOfCarsList.length);
        for (String name : nameOfCarsList) {
            carNameTest(name);
            cars.add(new Car(name));
        }
    }

    public String[] removeOverlap(String[] names) {
        Set<String> setNames = new HashSet<String>(Arrays.asList(names));
        return setNames.toArray(new String[0]);
    }

    public void oneTurn() {
        for (Car car:cars) {
            car.carTurn();
        }
    }

    public String[] splitNames(String names) {
        return names.split(",");
    }

    public void carNameTest(String name) {
        if (name.length() > NAME_LENGTH_MAXIMUM) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public int[] getCarsPosition() {
        int[] carsPosition = new int[cars.size()];

        for (int cnt=0; cnt < cars.size(); cnt++) {
            carsPosition[cnt] = cars.get(cnt).getPosition();
        }
        return carsPosition;
    }

    public String[] getCarsName() {
        String[] carsName = new String[cars.size()];

        for (int cnt=0; cnt<cars.size(); cnt++) {
            carsName[cnt] = cars.get(cnt).getName();
        }
        return carsName;
    }

    public List<String> victoryCars() {
        List<String> names =  new ArrayList<>();
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = calculatorPosition(car.getPosition(), maxPosition);
        }

        for (Car car : cars) {
            names = equalsMaxPosition(maxPosition, car, names);
        }
        return names;
    }

    public int calculatorPosition(int position, int maxPosition) {
        return Math.max(maxPosition, position);
    }

    public List<String> equalsMaxPosition(int maxPosition, Car car, List<String> names) {
        if (maxPosition == car.getPosition()) {
            names.add(car.getName());
        }
        return names;
    }
}
