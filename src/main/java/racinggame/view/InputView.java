package racinggame.view;

import java.util.Scanner;
import java.util.function.Supplier;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static Object retryableInput(Supplier<?> supplier) {
        try {
            return supplier.get();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage() + " 다시 입력해주세요.");
            return supplier.get();
        }
    }

    public static CarsCount retryableInputCarsCount() {
        return (CarsCount) retryableInput(InputView::inputCarsCount);
    }

    public static CarsCount inputCarsCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return new CarsCount(SCANNER.nextInt());
    }

    public static RaceCount retryableInputRaceCount() {
        return (RaceCount) retryableInput(InputView::inputRaceCount);
    }

    public static RaceCount inputRaceCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return new RaceCount(SCANNER.nextInt());
    }
}
