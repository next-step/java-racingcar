package step3.view;

import java.util.Scanner;

public class InputViewImpl implements InputView {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public int askNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    @Override
    public int askNumberOfTrys() {
        System.out.println("시도 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
