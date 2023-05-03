package racinggame;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import racinggame.exception.OverCarNameLengthException;
import racinggame.vo.Car;

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

    @DisplayName("자동차 움직이기")
    @Test
    void moveCar() {

        car.move();
        assertThat(car.getMoveCount()).isEqualTo(1);

    }

}
