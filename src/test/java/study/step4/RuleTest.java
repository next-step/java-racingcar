package study.step4;

import java.util.List;

import org.junit.jupiter.api.Test;
import study.step4.exception.RacingException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RuleTest {

    @Test
    void 룰_생성_성공() {
        List<Car> cars = List.of(
            new Car("소나타"),
            new Car("그랜져")
        );
        assertThat(new Rule(cars, 5)).isInstanceOf(Rule.class);
    }

    @Test
    void 자동차가_한대만_있는_경우() {
        List<Car> cars = List.of(
            new Car("그랜져")
        );
        assertThatExceptionOfType(RacingException.class)
            .isThrownBy(() -> new Rule(cars, 5))
            .withMessageContaining("RuleValidationError");
    }

    @Test
    void 시도_횟수_0회() {
        List<Car> cars = List.of(
            new Car("소나타"),
            new Car("그랜져")
        );
        assertThatExceptionOfType(RacingException.class)
            .isThrownBy(() -> new Rule(cars, 0))
            .withMessageContaining("RuleValidationError");
    }
}
