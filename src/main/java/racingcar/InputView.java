package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    private Cars cars;
    
    public Cars enterCarNames() {
        cars = new Cars(scanner.nextLine());
        return cars;
    }

    public void enterNumberOfGames(Cars cars) {
        new RacingGame(cars, scanner.nextInt());
    }

}
