package racingcar.domain.dto;

import racingcar.domain.exception.NameNullPointerException;
import racingcar.domain.exception.TryCountIllegalArgumentException;

public class InputDto {

    private static final int MINIMUM_TRY_COUNT = 1;

    private final String name;
    private final Integer tryCount;

    private InputDto(String name, Integer tryCount) {
        this.name = name;
        this.tryCount = tryCount;
    }

    public static InputDto of(String name, Integer tryCount) {
        valid(name, tryCount);
        return new InputDto(name, tryCount);
    }

    public String getName() {
        return name;
    }

    public Integer getTryCount() {
        return tryCount;
    }

    private static void valid(String name, Integer tryCount) {
        validName(name);
        validTryCount(tryCount);
    }

    private static void validName(String name) {
        if (name == null || name.isEmpty()) {
            throw new NameNullPointerException();
        }
    }

    private static void validTryCount(Integer tryCount) {
        if (tryCount == null || tryCount < MINIMUM_TRY_COUNT) {
            throw new TryCountIllegalArgumentException(MINIMUM_TRY_COUNT);
        }
    }

}
