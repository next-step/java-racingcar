package racingcar.ui;

import racingcar.common.Constants;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public int askToInsertNumberOfCars(){
        System.out.println(Constants.ASK_NUMBER_OF_CARS);
        return scanner.nextInt();
    }

    public int askToInsertNumberOfTries(){
        System.out.println(Constants.ASK_NUMBER_OF_TRIES);
        return scanner.nextInt();
    }
}
