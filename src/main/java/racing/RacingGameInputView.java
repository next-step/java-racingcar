package racing;

import java.util.Scanner;

public class RacingGameInputView {
    public static UserInputValueObject racingGameInput() {
        Scanner io = new Scanner(System.in);
        String time, carCount;

        System.out.println("자동차 대수는 몇대인가요?");
        carCount = io.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        time = io.nextLine();

        return new UserInputValueObject(carCount, time);
    }
}
