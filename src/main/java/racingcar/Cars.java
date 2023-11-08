package racingcar;

import racingcar.movablestrategy.MovableStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    public void race() {
        for(Car car : cars) {
            car.move();
            ResultView.carStatPrint(car);
        }
        ResultView.roundFinish();
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
        int maxPosition = measurementMaxPosition();

        return findRacerNameByPosition(maxPosition);
    }

    private int measurementMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(car.currentPosition(), maxPosition);
        }
        return maxPosition;
    }

    private String findRacerNameByPosition(int position) {
        StringJoiner racer = new StringJoiner(",");
        for (Car car : cars) {
            Optional.ofNullable(samePositionRacerSelection(car, position))
                    .ifPresent(racer::add);
        }
        return racer.toString();
    }
    private String samePositionRacerSelection(Car car, int position) {
        if(car.currentPosition() == position) {
            return car.racerName();
        }
        return null;
    }
}
