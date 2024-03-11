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

    private void createCarList(String names) {
        String[] nameList = Arrays.stream(names.split(COMMA_SEPARATOR))
                .map(String::trim).toArray(String[]::new);
        for (String s : nameList) {
            try {
                cars.addCar(Car.of(s));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
