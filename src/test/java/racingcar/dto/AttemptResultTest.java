package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AttemptResultTest {
    @Test
    @DisplayName("불변성 보장을 위한 방어적 복사 테스트")
    void name() {
        List<Car> cars = List.of(new Car("hoya"));
        AttemptResult attemptResult = new AttemptResult(cars);

        attemptResult.getCars().clear();

        assertThat(attemptResult.getCars()).isEqualTo(cars);
    }
}
