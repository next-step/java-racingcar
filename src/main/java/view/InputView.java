package view;

import core.GameSettings;

import java.util.Scanner;

public class InputView {
    public static final String CAR_GUIDE = "자동차 대수는 몇 대 인가요?";
    public static final String ROUND_GUIDE = "시도할 회수는 몇 회 인가요?";

    static Scanner scanner = new Scanner(System.in);

    private InputView() {};

    public static GameSettings getInputValue(){
        System.out.println(CAR_GUIDE);
        int carCount = scanner.nextInt();
        checkInputValue(carCount);

        System.out.println(ROUND_GUIDE);
        int round = scanner.nextInt();
        checkInputValue(round);

        return new GameSettings(carCount, round);
    }

    public static void checkInputValue(int inputValue) {
        if(inputValue <= 1 || inputValue != (int)inputValue) {
            throw new IllegalArgumentException();
        }
    }
}
