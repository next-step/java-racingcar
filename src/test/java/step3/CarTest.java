package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.exception.CarNameExceedException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CarTest {

    private static final int NOT_MOVED = 0;
    private static final int MOVED = 1;
    private static final String NAME = "pobi";
    private static final String EXCEPTION_NAME = "pobiiiii";
    private static final String EXCEPTION_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다";

    private Car car = new Car(NAME);

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 자동차_전진_실패(int random) {
        car.move(random);
        assertThat(car.position()).isEqualTo(NOT_MOVED);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 자동차_전진_성공(int random) {
        car.move(random);
        assertThat(car.position()).isEqualTo(MOVED);
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다")
    public void 자동차_이름_초과() {
        assertThatExceptionOfType(CarNameExceedException.class)
            .isThrownBy(() -> {
                new Car(EXCEPTION_NAME);
            }).withMessageMatching(EXCEPTION_MESSAGE);
    }

}
