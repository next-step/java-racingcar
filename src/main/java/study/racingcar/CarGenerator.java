package study.racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarGenerator {

    public static final String DEFAULT_SEPARATOR = ",";
    public static final String VALIDATE_EXCEPTION_MESSAGE = "입력된 자동차의 이름이 빈값이면 안됩니다.";

    public static List<Car> generateByString(String racingParticipantByName) {
        if (racingParticipantByName == null || racingParticipantByName.isEmpty()) {
            throw new IllegalArgumentException(VALIDATE_EXCEPTION_MESSAGE);
        }
        String[] split = racingParticipantByName.split(DEFAULT_SEPARATOR);
        if (split.length <= 0) {
            throw new IllegalArgumentException(VALIDATE_EXCEPTION_MESSAGE);
        }
        return Arrays.stream(split)
            .map(Car::new)
            .collect(Collectors.toList());
    }
}
