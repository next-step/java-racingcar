package racing.domain.car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racing.domain.car.exception.MakeCarException;

public final class CarFactory {

    private final String names;

    private static final String DELIMETER = ",";

    public CarFactory(String names) {
        validation(names);
        this.names = names;
    }

    private void validation(String names) {
        if (names == null || names.equals("") || names.isBlank()) {
            throw new MakeCarException("자동차는 1대 이상 입력 해야 합니다.");
        }
    }

    public Cars createCar() {
        List<Car> carList = Arrays.stream(names.split(DELIMETER))
            .map(Car::new)
            .collect(Collectors.toList());
        return new Cars(carList);
    }
}
