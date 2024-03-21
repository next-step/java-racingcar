package racingcar.domain.cars;

import static racingcar.config.RacingCarException.CAR_NAME_DUPLICATED;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarNames {

    private final List<String> names;

    private CarNames(final List<String> names) {
        this.names = names;
    }

    public static CarNames from(final String[] names) {
        final List<String> uniqueNames = uniqueNames(names);
        validateCarNamesAreNotDuplicated(names, uniqueNames);

        return new CarNames(uniqueNames);
    }

    private static List<String> uniqueNames(final String[] carNames) {
        return Arrays.stream(carNames)
                .map(String::trim)
                .distinct()
                .collect(Collectors.toList());
    }

    private static void validateCarNamesAreNotDuplicated(final String[] names, final List<String> uniqueNames) {
        if (areDuplicated(names, uniqueNames)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATED.message(names));
        }
    }

    private static boolean areDuplicated(final String[] names, final List<String> uniqueNames) {
        return names.length != uniqueNames.size();
    }

    public List<String> names() {
        return Collections.unmodifiableList(names);
    }
}
