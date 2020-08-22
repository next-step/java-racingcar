package racingcar.domain;
import racingcar.strategy.DoOneForward;
import racingcar.strategy.OneOrZeroForwardCondition;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static racingcar.Constants.EMPTY_CAR;

public class RacingGame {
    public static List<Car> RACE_RESULTS = new ArrayList<>( );
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

    public List<Car> startRacing() {
        List<Car> RACE_RESULTS = new ArrayList<>();
        if (ZeroOrMinusRacingCounts()) {
            return RACE_RESULTS;
        }
        RACE_RESULTS.addAll(moveOnceCars().getCars());
        RACE_RESULTS.add(EMPTY_CAR);
        countDownRacingCounts();
        return RACE_RESULTS;
    }

    private boolean ZeroOrMinusRacingCounts() {
        return getRacingCounts() <= 0;
    }
    private int countDownRacingCounts() {
        return getRacingCounts() - 1;
    }

    private Cars moveOnceCars() {
        for (Car car:getCars()) {
            car.move(new OneOrZeroForwardCondition(), new DoOneForward());
        }
        return this.cars;
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



