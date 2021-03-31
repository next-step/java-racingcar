package step3;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarTest {
    
    Car car;

    @BeforeEach
    void setup() {
        car = new Car();
    }

    @ParameterizedTest
    @CsvSource(value = {"true|1", "false|0"}, delimiter = '|')
    @DisplayName("차량의 전진 테스트")
    public void testMoveCaseOfTrue(boolean isMove, int position) {
        car.move(isMove);
        assertThat(car.getPosition()).isEqualTo(position);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"", "latte"})
    @DisplayName("차량의 명명규칙 검증 테스트")
    public void testCarNameLength(String name) {
        assertThatThrownBy(() -> {car.setName(name);}).isInstanceOf(IllegalStateException.class);
    }
}