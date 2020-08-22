package racingcar.domain;
import racingcar.strategy.DoOneForward;
import racingcar.strategy.OneOrZeroForwardCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private final RacingCounts racingCounts;
    private final Cars cars;

    public int getRacingCounts() {
        return racingCounts.getRacingCounts();
    }
    public List<Car> getCars() {
        return Collections.unmodifiableList(cars.getCars()); }

    public RacingGame(int carCounts, RacingCounts racingCounts) {
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

    public Cars startRacing() {
        for (int i = 0; i < getRacingCounts() ; i++) {
            moveCars();
        }
        return cars;
    }

    private void moveCars() {
        for (Car car:getCars()) {
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



