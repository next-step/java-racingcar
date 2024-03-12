package step3.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public Scanner scanner() {
        return this.scanner;
    }

    public void close() {
        this.scanner().close();
    }

    public int inputNumberOfCars() {
        System.out.println("자동차 대수는 몇 대인가요?");
        return inputInteger(scanner);
    }

    public int inputCountRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return inputInteger(scanner);
    }

    private int inputInteger(Scanner scanner){
        return scanner.nextInt();
    }

}
