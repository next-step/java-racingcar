package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {


    @DisplayName("생성 시 id 값 초기 값 1부터 1씩 증가")
    @Test
    void create_IdIncrementByOne() {
        Car benz = new Car("benz");
        Car audi = new Car("audi");

        assertThat(benz.getId()).isEqualTo(1);
        assertThat(audi.getId()).isEqualTo(2);
    }

    @DisplayName("이동")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @CsvSource({"true,1", "false,0"})
    void move(boolean movable, int expected) {
        Car car = new Car("benz");
        car.move(() -> movable);
        assertThat(car.getPosition()).isEqualTo(new Position(expected));
    }
}
