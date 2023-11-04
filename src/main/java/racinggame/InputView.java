package racinggame;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String PRINTLN_CAR_SIZE = "자동차 대수는 몇 대 인가요?";
    private static final String PRINTLN_RACING_COUNT = "시도할 회수는 몇 회 인가요?";

    public int carSize(){
        System.out.println(PRINTLN_CAR_SIZE);
        return scanner.nextInt();
    }

    public int racingCount(){
        System.out.println(PRINTLN_RACING_COUNT);
        return scanner.nextInt();
    }

}
