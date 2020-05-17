package game.ui;

import java.util.Scanner;

public class ConsoleRacingGameInputView implements RacingGameInputView {

    private static final String QUESTION_NUMBER_OF_CAR = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_TIME = "시도할 회수는 몇 회 인가요?";

    @Override
    public int getTime() {
        System.out.println(QUESTION_TIME);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public int getNumberOfCar() {
        System.out.println(QUESTION_NUMBER_OF_CAR);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
