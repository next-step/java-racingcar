package racingcar;

import java.util.Scanner;

public class InputView {

    public static RacingCar getRacingCarInput() {
        Scanner scanner = new Scanner(System.in);
        int carNums = getAnswerInput("자동차 대수는 몇 대 인가요?", scanner);
        int tryNums = getAnswerInput("시도할 횟수는 몇 회 인가요?", scanner);
        return new RacingCar(carNums, tryNums);
    }

    private static int getAnswerInput(String question, Scanner scanner) {
        System.out.println(question);
        String s = scanner.nextLine();
        return toInt(s);
    }

    public static int toInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException("정수를 입력해주세요.");
        }
    }
}
