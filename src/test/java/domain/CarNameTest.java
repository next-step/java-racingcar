package domain;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarNameTest {
    @Test
    @Order(1)
    void 자동차이름은_5글자를_초과할수_없다() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Order(2)
    void 자동차이름을_쉼표로_구분한다() {
        Cars cars = Cars.builder()
                .carsName("abc,cdf")
                .raceCondition(new RaceCondition())
                .build();
        assertThat(cars.checkSize(2)).isTrue();
    }

    @Test
    @Order(3)
    void 자동차이름_객체_생성() {
        CarName carName = new CarName("테스트");
        assertThat(carName.toString()).isEqualTo("테스트");
    }
}