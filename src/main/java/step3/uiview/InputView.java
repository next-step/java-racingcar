package step3.uiview;

import step3.message.Message;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    //자동차 대수를 입력받는다.
    public int inputCarNum() {
        System.out.println(Message.INPUT_CAR_NUM.message());
        return scanner.nextInt();
    }

    //시도할 회수를 입력받는다.
    public int inputAttemptNum() {
        System.out.println(Message.INPUT_ATTEMPT_NUM.message());
        return scanner.nextInt();
    }
}
