package racingcar;

import racingcar.movablestrategy.MovableStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Cars {
    private List<Car> cars = new ArrayList<Car>();

    public Cars(){}
    public Cars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }
    public Cars(String racerNames) {
        String[] names = RacerNameValidator.splitByComma(racerNames);
        for(String name : names) {
            cars.add(new Car(name));
        }
    }

    public Cars(int carCount, MovableStrategy movableStrategy) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(movableStrategy));
        }
    }

    public boolean carsReady(int racingCondition) {
        return cars.size() >= racingCondition;
    }

    public void race(int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            for(Car car : cars) {
                car.move();
                ResultView.carStatPrint(car);
            }
            ResultView.roundFinish();
        }
    }

    public int size() {
        return cars.size();
    }

    public boolean isParticipate(String racerName) {
        for(Car car : cars) {
            if (car.racerName().equals(racerName)) {
                return true;
            }
        }
        return false;
    }

    public void add(Car car) {
        cars.add(car);
    }

    public String mostFastest() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = measurementMaxPosition(car.currentPosition(), maxPosition);
        }
        StringJoiner fastestRacer = new StringJoiner(",");
        for (Car car : cars) {
            if (car.currentPosition() == maxPosition) {
                fastestRacer.add(car.racerName());
            }
        }
        return fastestRacer.toString();
    }

    private int measurementMaxPosition(int position, int maxPositionCondition) {
        if (position > maxPositionCondition) {
            return position;
        }
        return maxPositionCondition;
    }
}
