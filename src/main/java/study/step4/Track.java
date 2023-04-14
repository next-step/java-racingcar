package study.step4;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Track {
    private static final String DELIMITER = ",|:";
    private int finish;
    private List<Car> cars = new ArrayList<>();
    private List<Car> winnerCars = new ArrayList<>();

    public Track(String carNames, int finish) {
        this.finish = finish;
        createCars(carNames);
    }

    private void createCars(String carNames) {
        for (String carName : carNames.split(DELIMITER)) {
            cars.add(new Car(carName));
        }
    }

    public void startRacing() {
        for (Car car : cars) {
            car.move();
        }
    }

    public Boolean isRaceEnd() {
        int lastCarNumber = cars.size() - 1;
        return isFinish(cars.get(lastCarNumber).getAttemptCount());
    }

    private boolean isFinish(int carAttemptCount) {
        return finish == carAttemptCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void determineWinner() {
        for (Car car : cars) {
            isWinner(car, getWinnerPosition());
        }
    }

    public int getWinnerPosition() {
        return Collections.max(cars).getPosition();
    }
    private void isWinner(Car car, int winnerPosition) {
        if (car.getPosition() == winnerPosition) {
            winnerCars.add(car);
        }
    }
    public List<Car> getWinnerCars() {
        return winnerCars;
    }
}
