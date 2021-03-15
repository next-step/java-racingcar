package step3.view;

import java.util.Scanner;

public class InputView {

    private int cars;
    private int attemps;

    public void inputValues() {
        Scanner scan = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대인가요?");
        this.cars = scan.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        this.attemps = scan.nextInt();
    }

    public int howManyCars() {
        return cars;
    }

    public int getAttemps() {
        return attemps;
    }
}
