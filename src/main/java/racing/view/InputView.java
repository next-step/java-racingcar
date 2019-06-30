package racing.view;

import racing.model.Car;
import racing.model.CarName;
import racing.model.Cars;
import racing.model.Position;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final String COMMA = ",";
    private static Scanner scanner = new Scanner(System.in);

    public static Cars getCarsByNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return createCarsByName(splitWithComma(scanner.nextLine()));
    }

    public static int getRacingCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextInt();
    }

    private static Cars createCarsByName(String[] splitWithComma) {
        return new Cars(Stream.of(splitWithComma)
                .map(name -> Car.of(new CarName(name)))
                .collect(Collectors.toList()));
    }

    private static String[] splitWithComma(String string) {
        return string.split(COMMA);
    }
}
