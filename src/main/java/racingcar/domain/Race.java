package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.domain.car.RacingCars;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.domain.numbergenerator.RandomNumberGenerator;
import step2.PositiveInteger;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final PositiveInteger raceCount;
    private final List<RacingCars> cars;

    private Race(PositiveInteger raceCount, List<RacingCars> racingCars) {
        this.raceCount = raceCount;
        this.cars = racingCars;
    }

    public static Race from(int raceCount, List<Car> cars){
        PositiveInteger positiveRaceCount = PositiveInteger.from(raceCount);

        List<RacingCars> racingCarsList = new ArrayList<>();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        racingCarsList.add(new RacingCars(cars, numberGenerator));
        return new Race(positiveRaceCount, racingCarsList);
    }

    public void race(){
        for(int i = 0; i < raceCount.getValue(); i++){
            cars.get(i).raceCar();
            cars.add(cars.get(i).copy(cars.get(i)));
        }
    }

    public List<Car> getWinners(){
        return cars.get(raceCount.getValue()-1).getWinners();
    }

    public int getRaceCount(){
        return raceCount.getValue();
    }

    public RacingCars getRacingCarsPerRound(int round){
        return cars.get(round);
    }

}
