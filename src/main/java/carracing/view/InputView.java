package carracing.view;

import carracing.vo.Car;

import java.util.Scanner;

public class InputView {

    private static final String TRY_COUNT_QUESTION = "시도할 횟수는 몇회인가요?";
    private static final String CAR_COUNT_QUESTION = "자동차 대수는 몇대인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() { }

    public static Car input() {
        System.out.println(CAR_COUNT_QUESTION);
        int carCount = scanner.nextInt();
        System.out.println(TRY_COUNT_QUESTION);
        int tryCount = scanner.nextInt();

        return new Car(carCount, tryCount);
    }


}
