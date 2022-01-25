package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {

    private final List<Car> cars = new ArrayList<>();
    private final Random random = new Random();
    public Cars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void move() {
        cars.forEach(car -> car.move(random.nextInt(9)));
    }

//    public void moveT(List<Integer> randomNumberList) {
//        randomNumberList.forEach();
//        for (int randomNumber: randomNumberList) {
//            if (randomNumber >= GO_POSSIBLE_VALUE) {
//                Car car = cars.get(i);
//                int location = car.getLocation();
//                location++;
//                car.updateLocation(location);
//            }
//        }
//
//    }

    public int findMaxLocation() {
        int maxLocation = 0;
        for (Car car : cars) {
            maxLocation = Math.max(car.getLocation(), maxLocation);
        }
        return maxLocation;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

}
