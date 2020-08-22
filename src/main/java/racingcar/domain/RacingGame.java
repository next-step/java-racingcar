package racingcar.domain;
import racingcar.strategy.DoOneForward;
import racingcar.strategy.OneOrZeroForwardCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static racingcar.Constants.INIT_POSITION;

public class RacingGame {
    private int racingCounts;
    private Cars cars;

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars.getCars()); }

    public RacingGame(int carCounts, int racingCounts) {
        this.cars = createCars(carCounts);
        this.racingCounts = racingCounts;
    }

    public static Cars createCars(int carCounts) {
        List<Car> newCars = new ArrayList<>(carCounts);
        for (int i = 0; i < carCounts; i++) {
            newCars.add(new Car());
        }
        return Cars.createCars(newCars);
    }

    public List<Car> startRacing() {
        if (yesRacingCond()) {
            yesRacingCars();
        }
        return getCars();
    }

    public void yesRacingCars() {
        this.racingCounts--;
        moveCars();
    }

    public boolean yesRacingCond() {
        return this.racingCounts > 0;
    }

    private void moveCars() {
        for (Car car:cars.getCars()) {
            car.move(new OneOrZeroForwardCondition(), new DoOneForward());
        }
    }

}



/* BEFORE
    public List<Integer> allDoRace(int carCounts, int racingCounts) {
        this.carList = new ArrayList<>(carCounts);
        List<Integer> resultList = Arrays.asList(0);

        if (racingCounts == 0) {
            return resultList;
        }
        resultList = carList.stream( )
                .map(Car::getPosition)
                .collect(Collectors.toList( ));
        resultList.add(0);
        racingCounts -= 1;
        resultList.addAll(allDoRace(carCounts, racingCounts));
        return resultList;
    }

 */



