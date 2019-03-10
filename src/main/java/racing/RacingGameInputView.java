package racing;

import java.util.Scanner;

public class RacingGameInputView {
    public static RacingGame setInitCar(RacingGame rg, Scanner io) {
        while (true) {
            String inputValue;
            System.out.println("자동차 대수는 몇대인가요?");
            inputValue = io.nextLine();

            try {
                rg.setCarPositions(Integer.parseInt(inputValue));
            } catch (NumberFormatException e) {
                System.out.println("자동차 대수는 숫자만 입력 가능합니다. 다시 입력해주세요.");
                continue;
            }

            System.out.println("시도할 회수는 몇 회 인가요?");
            inputValue = io.nextLine();
            try {
                rg.setTime(Integer.parseInt(inputValue));
            } catch (NumberFormatException e) {
                System.out.println("시도할 횟수는 숫자만 입력 가능합니다. 다시 입력해주세요.");
                continue;
            }
            break;
        }

        return rg;
    }
}
