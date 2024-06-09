package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CarRacing {
    private List<Car> cars;
    private int tryCtn;
    private Random random;

    public CarRacing(String[] carNames, int tryCtn) {
        this.cars = initCar(carNames);
        this.tryCtn = tryCtn;
        this.random = new Random();
    }

    private List<Car> initCar(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void race() {
        for (Car car : cars) {
            car.move(random.nextInt(10) >= 4);
        }
    }

    public List<Car> getCars(){
        return cars;
    }

    public int getTryCnt(){
        return tryCtn;
    }

    public String getWinners(){
        int maxPosition = getMaxPosition();
        List<String> winnerNames = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winnerNames.add(car.getName());
            }
        }
        return String.join(", ", winnerNames);
    }

    private int getMaxPosition(){
        int maxPosition = 0;
        for(Car car : cars){
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
