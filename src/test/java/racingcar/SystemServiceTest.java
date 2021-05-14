package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.RacingCarView;
import racingcar.vo.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SystemServiceTest {

    private List<Car> carInfo;

    private static final int RANDOM_NUMBER = 10;
    private static final int MOVABLE_NUMBER = 4;

    @BeforeEach
    public void init() {
        carInfo = Arrays.asList(
                new Car("jeongggg", 2),
                new Car("hyeon", 3),
                new Car("jin", 1)
        );
    }

    @DisplayName("자동차 이름이 5자를 초과하는 경우 예외가 발생한다.")
    @Test
    public void invalidedName() {

        carInfo.stream().filter(s->s.getName().length() > 5).findAny().orElseThrow(IllegalArgumentException::new);
    }

}
