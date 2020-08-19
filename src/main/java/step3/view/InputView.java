package step3.view;

import step3.operation.InputValue;

public class InputView {
    InputValue iv = new InputValue();

    public int numOfCars(String data) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int result = iv.input(data);
        System.out.println(result);
        return result;
    }

    public int numberOfAttempts(String data) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int result = iv.input(data);
        System.out.println(result);
        return result;
    }
}
