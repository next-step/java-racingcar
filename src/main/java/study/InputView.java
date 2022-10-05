package study;

import java.util.Scanner;

public class InputView {

    private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    Scanner sc = new Scanner(System.in);

    public int carCount() {
        System.out.println(CAR_COUNT_MESSAGE);
        return new Number(sc.nextInt()).getValue();
    }

    public int tryCount(){
        System.out.println(TRY_COUNT_MESSAGE);
        return new Number(sc.nextInt()).getValue();
    }

}
