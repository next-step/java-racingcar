package race.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarNames {

    private final List<CarName> carNames;

    private CarNames(List<CarName> carNames) {
        this.carNames = Collections.unmodifiableList(carNames);
    }

    public static CarNames createWithDelimiter(String strCarNames, String delimiter) {
        List<CarName> carNames = Arrays.stream(strCarNames.split(delimiter))
                .map(CarName::new)
                .collect(Collectors.toList());
        return new CarNames(carNames);
    }

    public CarName get(int index) {
        return carNames.get(index);
    }

    public int size() {
        return carNames.size();
    }
}
