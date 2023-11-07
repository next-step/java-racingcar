package step4_racintCarWithWinner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("각 자동차에 이름을 부여할 수 있다")
    void createCar(){
        String name = "보리차붕붕";
        assertThat(new Car(name).carName()).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void nameLength(){
        assertThatThrownBy(() -> new Car("보리차보리차"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
