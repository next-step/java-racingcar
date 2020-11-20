package race.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {
    @DisplayName("test for set/get car name")
    @ValueSource(strings = {"", "pobi", "crong", "honux"})
    @ParameterizedTest
    void getName(String name) {
        assertThat(new Car(Engine.BROKEN_ENGINE, name)).isNotNull();
    }

    @DisplayName("test for invalid car names")
    @NullSource
    @ValueSource(strings = {
            "pororo", "pengsoo"
    })
    @ParameterizedTest
    void setIllegalName(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(Engine.BROKEN_ENGINE, name));
    }

    @DisplayName("test for perfect Engine")
    @Test
    void perfectEngine() {
        Car car = new Car(Engine.PERFECT_ENGINE, "");
        assertThat(car.run().getPosition()).isEqualTo(1);
    }

    @DisplayName("test for broken Engine")
    @Test
    void brokenEngine() {
        Car car = new Car(Engine.BROKEN_ENGINE, "");
        assertThat(car.run().getPosition()).isEqualTo(0);
    }
}
