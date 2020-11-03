package racingcar.ui;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    private final String ASK_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private final String ASK_NUMBER_OF_TRIES = "시도할 회수는 몇 회 인가요?";

    public int askToInsertNumberOfCars(){
        System.out.println(ASK_NUMBER_OF_CARS);
        return scanner.nextInt();
    }

    public int askToInsertNumberOfTries(){
        System.out.println(ASK_NUMBER_OF_TRIES);
        return scanner.nextInt();
    }
}
