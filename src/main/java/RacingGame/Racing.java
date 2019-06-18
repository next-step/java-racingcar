package RacingGame;

import java.util.*;
import java.util.stream.Collectors;

public class Racing {

    private int time;
    private List<Car> cars;
    private OutputView outputView;

    public Racing(int time, List<String> inputCarNames) {
        this.time = time;
        this.cars = this.arrayWithCar(inputCarNames);
        this.outputView = new OutputView();
    }

    public int getTime() {
        return time;
    }

    private List<Car> arrayWithCar(List<String> carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void raceCarMoveLoop() {
        for (Car car : this.cars) {
            car.nextRace();
        }
    }

    public void raceStart() {
        for (int i = 0; i < this.time; i++) {
            this.raceCarMoveLoop();
            outputView.printRace(this.cars);
        }
    }

    public int maxPosition() {
        Optional<Car> max = cars.stream().max(Comparator.comparing(Car::getPosition));

        return max.get().getPosition();
    }

    public List<String> winners() {
        return cars.stream().filter(car -> {
            int maxPosition = maxPosition();
            return car.getPosition() == maxPosition;
        }).map(Car::getName).collect(Collectors.toList());
    }
}
