package racingcar;

import java.util.Scanner;

public class InputView {

    public static RacingCar getRacingCarInput() {
        int carNums = getAnswerInput("자동차 대수는 몇 대 인가요?");
        int tryNums = getAnswerInput("시도할 횟수는 몇 회 인가요?");
        return new RacingCar(carNums, tryNums);
    }

    private static int getAnswerInput(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        return toInt(scanner.nextLine());
    }

    public static int toInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException("정수를 입력해주세요.");
        }
    }
}
