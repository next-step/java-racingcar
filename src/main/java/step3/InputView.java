package step3;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String ASK_MESSAGE_FOR_A_NUMBER_OF_CAR = "자동차 대수는 몇 대 인가요?";
    private static final String ASK_MESSAGE_FOR_COUNT = "시도할 회수는 몇 회 인가요?";

    public int getNumberOfCar() {
        System.out.println(ASK_MESSAGE_FOR_A_NUMBER_OF_CAR);
        int numberOfCars = scanner.nextInt();
        if (numberOfCars <= 0) {
            throw new RuntimeException("자동차 대수는 양수여야 합니다.");
        }
        return numberOfCars;
    }

    public int getCount() {
        System.out.println(ASK_MESSAGE_FOR_COUNT);
        int count = scanner.nextInt();
        if (count <= 0) {
            throw new RuntimeException("시도할 횟수는 양수여야 합니다.");
        }
        return count;
    }

}