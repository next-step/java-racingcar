package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.vo.Car;

import java.util.Arrays;
import java.util.List;

public class SystemServiceTest {

    private List<Car> carInfo;

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

        carInfo.stream().filter(s -> s.getName().length() > 5).findAny().orElseThrow(IllegalArgumentException::new);
    }

}
