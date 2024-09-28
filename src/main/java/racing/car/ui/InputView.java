package racing.car.ui;

import java.util.Scanner;

public class InputView {

    private static final String CAR_QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String TRY_QUESTION = "시도할 횟수는 몇 회 인가요?";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int input(){
        return scanner.nextInt();
    }

    public void carQuestion(){
        System.out.println(CAR_QUESTION);
    }

    public void tryQuestion() {
        System.out.println(TRY_QUESTION);
    }
}
