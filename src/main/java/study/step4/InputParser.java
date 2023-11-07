package study.step4;

import java.util.ArrayList;
import java.util.List;

import study.step4.exception.InputParserException;


public class InputParser {

    public static final String DELIMITER = ",";

    public static List<Car> parse(String carNames) {
        String[] carNameArray = carNames.split(DELIMITER);
        List<Car> cars = new ArrayList<>();
        for (String carName: carNameArray) {
            validate(carName);
            cars.add(new Car(carName.trim()));
        }
        return cars;
    }

    private static void validate(String string) {
        if (!isValidInputString(string)) {
            throw new InputParserException("InputParserError: 자동차 이름은 공백을 입력할 수 없습니다.");
        }
    }

    private static boolean isValidInputString(String string) {
        return string != null && !string.isBlank();
    }

}
