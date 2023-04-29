package racingcar;

import step2.PositiveInteger;
import racingcar.car.Car;
import racingcar.car.RacingCars;
import racingcar.numbergenerator.RandomNumberGenerator;
import racingcar.printer.RacePrinter;

import java.util.List;

public class Race {

    private final PositiveInteger raceCount;
    private final RacingCars cars;

    private Race(PositiveInteger raceCount, RacingCars cars) {
        this.raceCount = raceCount;
        this.cars = cars;
    }

    public static Race from(int raceCount, List<Car> cars){
        PositiveInteger positiveRaceCount = PositiveInteger.from(raceCount);

        return new Race(positiveRaceCount, new RacingCars(cars, new RandomNumberGenerator()));
    }

    public void race(){
        RacePrinter.printRaceStart();
        for(int i = 0; i < raceCount.getValue(); i++){
            cars.raceCar();
            RacePrinter.printPerRound(cars.getCars());
        }
        RacePrinter.printWinners(cars.getWinners());
    }

}
