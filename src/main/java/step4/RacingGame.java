package step4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/*
 * Racing Game
 * ver. 1.0
 * 2020.05.27
 * Copyright ...
 */
public class RacingGame {

    private static final String ILLEGAL_INPUT_ERROR = "Inputs can't be negative number.";
    private static final String RANKED_STRING_DELIMITER = ",";
    private List<Car> cars = new ArrayList<>();
    private int playTimes;

    private RacingGame() {
    }

    public RacingGame(String[] carsNames, int playTimes) {

        int carsCount = carsNames.length;
        if (carsCount <= 0 || playTimes < 0) throw new IllegalArgumentException(ILLEGAL_INPUT_ERROR);

        /* set new car */
        setupCars(carsNames);

        /* set play times. */
        this.playTimes = playTimes;

    }

    private void setupCars(String[] carsNames) {
        for (int i = 0; i < carsNames.length; i++) {
            cars.add(new Car(carsNames[i], 0, new CarMoveRandomStrategy()));
        }
    }

    public void play() {

        for (int i = 0; i < playTimes; i++) {
            for (Car car : cars) {
                car.move();
            }
            ResultView.viewResult(cars);
        }

        /* result */
        String winners = getWinners(cars);
        ResultView.printWinner(winners);

    }

    private String getWinners(List<Car> cars) {
        Optional<Car> max = cars.stream().max((o1, o2) -> (o1.getLocation() >= o2.getLocation()) ? 1 : -1);
        Stream<Car> ranked = cars.stream().filter(o -> o.getLocation() == max.get().getLocation());
        String winners = ranked.map(Car::getCarName).collect(Collectors.joining(RANKED_STRING_DELIMITER));
        return winners;
    }


}
