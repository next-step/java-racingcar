package racinggame.view;

import java.util.Scanner;

public class InputView {
    public static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";

    public int inputCarCount(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(CAR_COUNT_QUESTION);
        return scanner.nextInt();
    }
}
