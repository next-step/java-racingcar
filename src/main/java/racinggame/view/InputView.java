package racinggame.view;

import racinggame.domain.CarsNames;
import racinggame.domain.RaceCount;

import java.util.Scanner;
import java.util.function.Supplier;

public class InputView {

    private static final String NAME_SEPARATOR = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static Object retryableInput(Supplier<?> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " 다시 입력해주세요.");
            return supplier.get();
        }
    }

    public static CarsNames retryableInputCarsNames() {
        return (CarsNames) retryableInput(InputView::inputCarsNames);
    }

    public static CarsNames inputCarsNames() {
        System.out.println("경주할 자동자 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.");
        return new CarsNames(SCANNER.nextLine().split(NAME_SEPARATOR));
    }

    public static RaceCount retryableInputRaceCount() {
        return (RaceCount) retryableInput(InputView::inputRaceCount);
    }

    public static RaceCount inputRaceCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return new RaceCount(SCANNER.nextInt());
    }
}
