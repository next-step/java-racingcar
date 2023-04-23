package study.step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String[] carNames) {
        cars = new ArrayList(carNames.length);

        for(String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public List<Car> asList() {
        return cars;
    }

    String findWinners() {
        Position carMaxPosition = findCarMaxPosition();
        ArrayList<Name> names = findWinnerNames(cars, carMaxPosition);

        return namesToString(names);
    }

    Position findCarMaxPosition() {
        Position maxPosition = new Position(0);
        for (Car car : cars) {
            if(car.isBiggerPosition(maxPosition)) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    ArrayList<Name> findWinnerNames(List<Car> cars, Position maxPosition) {
        ArrayList<Name> winnerNames = new ArrayList<>();

        for (Car car : cars) {
            if (!car.isCarPosition(maxPosition)) {
                continue;
            }
            winnerNames.add(car.getName());
        }
        return winnerNames;
    }

    private static String namesToString(ArrayList<Name> names) {
        String winnerNames = "";
        for (int i = 0; i < names.size(); i++) {
            winnerNames += names.get(i);

            if (i == names.size() - 1) {
                break;
            }
            winnerNames += ",";
        }

        return winnerNames;
    }

}
