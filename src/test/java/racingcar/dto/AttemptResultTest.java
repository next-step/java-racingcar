package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AttemptResultTest {
    @Test
    @DisplayName("자동차의 상태를 반환한다.")
    void formatAttempt() {
        String lineSeparator = System.lineSeparator();
        AttemptResult attemptResult = new AttemptResult(List.of(new Car(0, "pobi"), new Car(1, "catsb"), new Car(2, "hoya")));
        assertThat(attemptResult.formatAttempt(lineSeparator)).isEqualTo("pobi : " + lineSeparator + "catsb : -" + lineSeparator + "hoya : --" + lineSeparator + lineSeparator);
    }

    @Test
    @DisplayName("불변성 보장을 위한 방어적 복사 테스트")
    void getter() {
        List<Car> cars = List.of(new Car("hoya"));
        AttemptResult attemptResult = new AttemptResult(cars);

        attemptResult.getCars().clear();

        assertThat(attemptResult.getCars()).isEqualTo(cars);
    }
}
