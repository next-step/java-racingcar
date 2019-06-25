package racing.view;

import racing.Car;
import racing.CarName;
import racing.Position;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final String COMMA = ",";

    public static List<Car> getCarsByNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return createCarsByName(splitWithComma(new Scanner(System.in).nextLine()));
    }

    private static List<Car> createCarsByName(String[] splitWithComma) {
        return Stream.of(splitWithComma).map(name -> Car.of(new CarName(name), new Position())).collect(Collectors.toList());
    }

    private static String[] splitWithComma(String string) {
        return string.split(COMMA);
    }
}
