package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Car {
    private final String name;

    public Car(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class CarTest {
    @DisplayName("자동차는 이름을 가진다")
    @ParameterizedTest
    @ValueSource(strings = {"jason", "이혜린"})
    public void name(final String name) {
        final Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }
}
