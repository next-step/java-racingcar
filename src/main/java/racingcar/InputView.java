package racingcar;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_REPEAT_MESSAGE = "시도할 횟수는 몇 회 인가요?";

    static Scanner sc = new Scanner(System.in);

    public static int getCountOfCar(){
        System.out.println(INPUT_COUNT_MESSAGE);
        return sc.nextInt();
    }

    public static int getCountOfRepeat(){
        System.out.println(INPUT_REPEAT_MESSAGE);
        return sc.nextInt();
    }
}
