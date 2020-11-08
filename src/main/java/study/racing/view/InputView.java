package study.racing.view;

import study.racing.CarRacing;

import java.util.Scanner;

public class InputView {

    private static String INPUT_CAR_MESSAGE = "자동차 대수를 입력하세요.";
    private static String INPUT_TRY_MESSAGE = "시도 횟수를 입력하세요.";

    private static Scanner scanner = new Scanner(System.in);

    private InputView(){}
    public static int getCarCount(){
        System.out.println(INPUT_CAR_MESSAGE);
        return scanner.nextInt();
    }

    public static int getTryCount(){
        System.out.println(INPUT_TRY_MESSAGE);
        return scanner.nextInt();
    }
}
