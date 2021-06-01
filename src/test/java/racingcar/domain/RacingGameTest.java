package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingGameTest {

    private List<Car> carInfo = new ArrayList<>();

    @DisplayName("자동차 이름이 5자를 초과하는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"jeonggggg,hyeon,jin"})
    public void splitString(String input) {
        assertThrows(IllegalArgumentException.class, () -> new Car(input));
    }

}
