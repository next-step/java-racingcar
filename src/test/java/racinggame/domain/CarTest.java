package racinggame.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.OverCarNameLengthException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarTest {

    private Car car;

    @BeforeAll
    void setUp() {
        this.car = new Car(0, "pobi");
    }

    @DisplayName("자동차 생성")
    @Test
    void createCar() {

        assertThat(car.getNumber()).isEqualTo(0);
        assertThat(car.getMoveCount()).isEqualTo(0);
        assertThat(car.getName()).isEqualTo("pobi");

    }

    @DisplayName("자동차 생성 이름 5자 초과 에러 확인")
    @Test
    void overCarName() {

        assertThatThrownBy(
                () -> {
                    car = new Car(0, "ONETWO");
                }
        ).isInstanceOf(OverCarNameLengthException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");


    }

    @DisplayName("자동차를 움직일 수 있는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {3, 4})
    void canMoveCar(int random) {
        boolean canMove = car.canMove(random);
        if (random > 4) {
            assertThat(canMove).isTrue();
        }
        assertThat(canMove).isFalse();
    }

}
