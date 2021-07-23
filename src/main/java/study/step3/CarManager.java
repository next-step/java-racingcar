package study.step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarManager {

    private static final int VALID_CAR_NUMBER = 1;
    private static final int START_POSITION = 1;
    public static final String ILLEGAL_CAR_NUMBER = "요구 되는 차량 숫자는 " + VALID_CAR_NUMBER + "보다 크거나 같아야 합니다 -> ";

    public List<Car> getCars(int carNumber) {
        validation(carNumber);
        return IntStream.range(0, carNumber)
                .mapToObj(index -> new Car(START_POSITION))
                .collect(Collectors.toList());
    }

    private void validation(int carNumber) {
        if (carNumber < VALID_CAR_NUMBER) {
            throw new IllegalArgumentException(ILLEGAL_CAR_NUMBER + carNumber);
        }
    }
}
