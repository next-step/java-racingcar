package racingcar.view;

import java.util.Scanner;

public class InputCountView implements InputView{
    private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String RACE_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner;

    public InputCountView() {
        scanner = new Scanner(System.in);
    }

    private int readCarCount() {
        System.out.println(CAR_COUNT_MESSAGE);
        return readCount();
    }

    private int readRaceCount() {
        System.out.println(RACE_COUNT_MESSAGE);
        return readCount();
    }

    private int readCount() {
        return scanner.nextInt();
    }

    @Override
    public Integer readCar() {
        return readCarCount();
    }

    @Override
    public Integer readRace() {
        return readRaceCount();
    }
}
