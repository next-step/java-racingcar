package step3.study;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner;
    private int carCount;
    private int tryCount;

    public InputView() {
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
    }

    public void input() {
        inputCarCount();
        inputTryCount();
        Racing racing = new Racing(this.carCount, this.tryCount);
        racing.start();
    }

    public void inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        carCount = Validator.numberCheck(scanner.next());
    }

    public void inputTryCount() {
        System.out.println("시도할 회수는 몇 대 인가요?");
        tryCount = Validator.numberCheck(scanner.next());
    }
}
