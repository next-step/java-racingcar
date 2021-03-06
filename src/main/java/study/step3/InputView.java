package study.step3;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public int enterNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }
}
