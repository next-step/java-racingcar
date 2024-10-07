package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimiterCarCreationStrategyTest {
    private final DelimiterCarCreationStrategy strategy = new DelimiterCarCreationStrategy();

    @Test
    @DisplayName("쉼표로 구분된 이름들로 자동차를 생성한다.")
    void create() {
        String names = "pobi,catsb,hoya";
        List<Car> actualCars = strategy.create(names);
        assertThat(actualCars).isEqualTo(List.of(new Car("pobi"), new Car("catsb"), new Car("hoya")));
    }
}
