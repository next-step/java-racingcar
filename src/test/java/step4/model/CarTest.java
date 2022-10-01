package step4.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.util.FixedNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    Car car;

    @BeforeEach
    void beforeEach() {
        car = new Car("naho");
    }

    @Test
    @DisplayName("생성된 자동차의 움직임 횟수는 0으로 초기화 되어있어야 한다.")
    void initCarTest() {
        assertThat(car.getMoveCnt()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차의 이름은 객체 생성시의 값을 초기화 되어야 한다")
    void initCarNameTest() {
        assertThat(car.getName()).isEqualTo("naho");
    }

    @Test
    @DisplayName("자동차가 제대로 움직이는가?")
    void moveCarTest() {
        car.move(new FixedNumberGenerator().generate(5));
        assertThat(car.getMoveCnt()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = "namkun, asdfgh")
    @DisplayName("생성된 자동차의 이름은 다섯글자를 넘기면 안된다.")
    void checkNameConditionTest(String name) {
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(RuntimeException.class);
    }

}