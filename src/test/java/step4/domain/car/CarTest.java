package step4.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.car.name.Name;
import step4.domain.car.position.Position;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("Car 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        String name = "test";

        // when
        Car car = new Car(name);

        // test
        assertThat(car).isNotNull();
    }

    @DisplayName("Car 인스턴스 이동 여부 테스트")
    @Test
    void 이동() {
        // given
        Car car = new Car("test");

        // when
        car.move(() -> true);
        Position position = car.position();
        int actual = position.position();

        // then
        assertThat(actual).isEqualTo(1);
    }

    @DisplayName("Car 인스턴스 이름 여부 테스트")
    @Test
    void 이름() {
        // given
        String expected = "test";
        Car car = new Car(expected);

        // when
        Name name = car.name();
        String actual = name.name();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("Car 인스턴스 우승자 여부 테스트")
    @Test
    void 승자(){
        // given
        String expected = "test";
        Car car = new Car(expected);

        car.move(()->true);
        boolean actual = car.isWinner(1);

        // then
        assertThat(actual).isTrue();
    }

}