package step3;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    private static String ASK_QUESTION_FOR_A_NUM_OF_CAR = "자동차 대수는 몇 대 인가요?";
    private static String ASK_QUESTION_FOR_A_NUM_OF_TRIAL = "시도할 회수는 몇 회 인가요?";

    public static int getNumOfCar() {
        System.out.println(ASK_QUESTION_FOR_A_NUM_OF_CAR);
        int numOfCar = Integer.parseInt(scanner.nextLine());
        if (numOfCar <= 0) {
            throw new RuntimeException("자동차 대수는 양수여야 합니다.");
        }
        return numOfCar;
    }

    public static int getNumOfTrial() {
        System.out.println(ASK_QUESTION_FOR_A_NUM_OF_TRIAL);
        int numOfTrial = Integer.parseInt(scanner.nextLine());
        if (numOfTrial <= 0) {
            throw new RuntimeException("시도할 횟수는 양수여야 합니다.");
        }
        return numOfTrial;
    }
}
