package racing.model;

import java.util.HashMap;
import java.util.Map;

public class RacingCarName {
    private static final int MAX_RACING_CAR_NAME_LENGTH = 5;
    private static final Map<String, RacingCarName> racingCarNameMap = new HashMap<>();

    private final String name;

    static RacingCarName valueOf(String name) {
        RacingCarName racingCarName = racingCarNameMap.get(name);
        if (racingCarName == null) {
            racingCarName = new RacingCarName(name);
            racingCarNameMap.put(name, racingCarName);
        }
        return racingCarName;
    }

    private RacingCarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNotEmpty(name);
        validateMaxLength(name);
    }

    private void validateNotEmpty(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 비었습니다.");
        }
    }

    private void validateMaxLength(String name) {
        if (name.length() > MAX_RACING_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차 이름은 %d자를 넘을 수 없습니다."
                    , MAX_RACING_CAR_NAME_LENGTH));
        }
    }

    String getName() {
        return name;
    }
}
