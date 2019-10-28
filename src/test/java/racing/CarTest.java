package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car("dave");
    }

    @ParameterizedTest
    @CsvSource(value = {"5:true", "2:false", "4:true"}, delimiter = ':')
    @DisplayName("car 이동 테스트 테스트")
    void move(int input, boolean result) {
        assertThat(car.move(input)).isEqualTo(result);
    }

    @Test
    @DisplayName("car 다 회 이동 테스트 테스트")
    void multipleMove() {
        int tryCount = 3;
        int[] random = {5, 2, 4};

        for (int i = 0; i < tryCount; i++) {
           car.move(random[i]);
        }

        assertThat(car.position()).isEqualTo(2);
    }
}
