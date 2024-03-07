package carRacing.race;

import carRacing.car.Cars;
import carRacing.common.RandomGenerator;
import carRacing.car.Car;

import java.util.*;

public class RacingGame {
    private final RandomGenerator generator;
    private final Cars cars;
    private final RacingGameUI ui;
    private static final String COMMA_SEPARATOR = ",";

    private RacingGame(RandomGenerator generator, Cars cars, RacingGameUI ui) {
        this.generator = generator;
        this.cars = cars;
        this.ui = ui;
    }

    public static RacingGame of(RandomGenerator generator, Cars cars, RacingGameUI ui){
        return new RacingGame(generator,cars,ui);
    }

    public void startRacing(String names, int trialCount) throws IllegalAccessException {
        createCarList(names);
        runRacingRounds(trialCount);
        ui.printWinners(cars.getWinners().toString());
    }

    private void runRacingRounds(int trialCount) {
        for (int trial = 0; trial < trialCount; trial++) {
            cars.forEach(car -> {
                car.updatePosition(generator.generate());
            });
            ui.printTrack(cars, trial);
        }
    }

    //try-catch? 예외 전파 무엇이 좋을까요?
    private void createCarList(String names) throws IllegalAccessException {
        String[] nameList = Arrays.stream(names.split(COMMA_SEPARATOR))
                .map(String::trim).toArray(String[]::new);
        for (int i = 0; i < nameList.length; i++) {
            cars.addCar(Car.of(nameList[i]));
        }
    }

}
