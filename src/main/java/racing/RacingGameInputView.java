package racing;

import java.util.Scanner;

public class RacingGameInputView {
    public static UserInputValueObject racingGameInput() {
        Scanner io = new Scanner(System.in);
        String time, carNames;

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        carNames = io.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        time = io.nextLine();

        try {
            return new UserInputValueObject(carNames, Integer.parseInt(time));
        } catch (NumberFormatException e) {
            System.out.println("자동차대수 및 회수는 숫자만 입력가능합니다.");
            throw new NumberFormatException();
        }
    }
}
