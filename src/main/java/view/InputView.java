package view;

import java.util.Scanner;

public class InputView {

    public static final String CAR_GUIDE = "자동차 대수는 몇 대 인가요?";
    public static final String ROUND_GUIDE = "시도할 회수는 몇 회 인가요?";

    public static int carCount;
    public static int round;

    static Scanner scanner = new Scanner(System.in);

    public static void getInputValue(){
        System.out.println(CAR_GUIDE);
        carCount = scanner.nextInt();
        checkInputValue(carCount);

        System.out.println(ROUND_GUIDE);
        round = scanner.nextInt();
        checkInputValue(round);
    }

    public static void checkInputValue(int inputValue) {
        if(inputValue < 0 || inputValue != (int)inputValue) {
            throw new IllegalArgumentException();
        }
    }
}
