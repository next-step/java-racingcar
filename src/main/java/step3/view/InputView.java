package step3.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NUMBER_OF_CAR = "자동차 대수는 몇 대 인가요?";
    private static final String COUNT = "시도할 회수는 몇 회 인가요?";

    public int numberOfCar() {
        System.out.println(NUMBER_OF_CAR);
        return SCANNER.nextInt();
    }

    public int count() {
        System.out.println(COUNT);
        return SCANNER.nextInt();
    }

}
