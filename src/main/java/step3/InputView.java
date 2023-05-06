package step3;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);
    private String ASK_QUESTION_FOR_A_NUM_OF_CAR = "자동차 대수는 몇 대 인가요?";
    private String ASK_QUESTION_FOR_A_NUM_OF_TRIAL = "시도할 회수는 몇 회 인가요?";

    public int getNumOfCar() {
        System.out.println(ASK_QUESTION_FOR_A_NUM_OF_CAR);
        int numOfCar = scanner.nextInt();
        if (numOfCar <= 0) {
            throw new RuntimeException("자동차 대수는 양수여야 합니다.");
        }
        return numOfCar;
    }

    public int getNumOfTrial() {
        System.out.println(ASK_QUESTION_FOR_A_NUM_OF_TRIAL);
        int numOfTrial = scanner.nextInt();
        if (numOfTrial <= 0) {
            throw new RuntimeException("시도할 횟수는 양수여야 합니다.");
        }
        return numOfTrial;
    }
}
