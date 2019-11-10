package racing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private static final String COMMA_CHARACTER = ",";
    private static final String DUPLICATE_NAME_MESSAGE = "중복된 이름이 있습니다.";
    private final List<Car> cars = new ArrayList<>();

    public void createCars(String inputCarNames) {
        inputCarNames = inputCarNames.trim();
        Set<String> noDuplicateNames = isDuplication(inputCarNames);
        for (String name : noDuplicateNames) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    public Set<String> isDuplication(String inputCarNames) {
        String[] carNames = inputCarNames.split(COMMA_CHARACTER);
        Set<String> noDuplicateNames = new HashSet<>();
        for (String carName : carNames) {
            noDuplicateNames.add(carName);
        }

        if (noDuplicateNames.size() != carNames.length) {
            throw new IllegalArgumentException(DUPLICATE_NAME_MESSAGE);
        }

        return noDuplicateNames;
    }

}
