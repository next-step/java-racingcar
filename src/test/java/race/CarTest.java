package race;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    void move() {
        Car car = new Car(UUID.randomUUID().toString().substring(0, 3));
        int moveCount = (new Random()).nextInt(100);

        for (int i = 0; i < moveCount; i++) {
            car.move();
        }

        assertThat(car.location()).isEqualTo(moveCount);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void invalidName_blank(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "abcdefff"})
    void invalidName_tooLong(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void invalidName_null() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
