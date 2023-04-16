package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int[] inputView() {

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCar = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfRounds = scanner.nextInt();

        int[] array = { numberOfCar, numberOfRounds };
        return array;
    }

}
