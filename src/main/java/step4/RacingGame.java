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

    private Cars cars = new Cars(new ArrayList<>());

    private int playTimes;

    private RacingGame() {
    }

    public RacingGame(String[] carsNames, int playTimes) {

        int carsCount = carsNames.length;
        if (carsCount <= 0 || playTimes < 0) throw new IllegalArgumentException(ILLEGAL_INPUT_ERROR);

        /* set new car */
        cars.setupCars(carsNames, new CarMoveRandomStrategy());

        /* set play times. */
        this.playTimes = playTimes;

    }


    public void play() {

        for (int i = 0; i < playTimes; i++) {
            cars.move();
            ResultView.viewResult(cars);
        }

        /* result */
        String winners = cars.getWinners();
        ResultView.printWinner(winners);

    }

}
