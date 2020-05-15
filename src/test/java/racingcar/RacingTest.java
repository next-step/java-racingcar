package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.moving.RandomMovingStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    private List<String[]> carNames = Arrays.asList(
            new String[] { "", "name" },
            new String[] { },
            new String[] { null, "name" },
            new String[] { "name1", "name2", "name3" }
    );

    @DisplayName("Racing 생성: Car 의 이름 배열을 생성자의 인자로 받아 생성")
    @Test
    void create() {
        assertThatCode(() -> Racing.of(carNames.get(3)))
                .doesNotThrowAnyException();
    }

    @DisplayName("Racing 생성 실패: name 이 빈 문자열이나 null 인 경우 예외 발생")
    @Test
    void createByThrown() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Racing.of(carNames.get(0)));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Racing.of(carNames.get(1)));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Racing.of(carNames.get(2)));
    }

    @DisplayName("run 실패: Car 의 이동 전략이 null 인 경우 IllegalArgumentException 발생")
    @Test
    void failureRunByStrategyIsNull() {
        Racing racing = Racing.of(carNames.get(3));

        assertThatThrownBy(() -> racing.run(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임을 한 번 수행할 때마다 만들어진 Car 는 이동 또는 정지")
    @Test
    void move() {
        Racing racing = Racing.of(carNames.get(3));
        racing.run(new RandomMovingStrategy());

        assertThat(racing.getCars()
                .stream()
                .map(Car::getPosition)).containsAnyOf(Car.DEFAULT_DISTANCE, Car.DEFAULT_DISTANCE + 1);
    }
}
