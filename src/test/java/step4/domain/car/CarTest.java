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
        String name = "test0";

        // when
        Car actualCar = new Car(name);
        Car expectedCar = new Car(name);

        // test
        assertThat(actualCar).isEqualTo(expectedCar);

    }

    @DisplayName("Car 인스턴스 이동 여부 테스트")
    @Test
    void 이동() {
        // given
        Car car = new Car("test1");

        // when
        car.move(() -> true);
        Position actualPosition = car.position();
        Position expectedPosition = new Position(1);

        // then
        assertThat(actualPosition).isEqualTo(expectedPosition);

    }

    @DisplayName("Car 인스턴스 이름 여부 테스트")
    @Test
    void 이름() {
        // given
        String expected = "test2";
        Car car = new Car(expected);

        // when
        Name actualName = car.name();
        Name expectedName = new Name(expected);

        // then
        assertThat(actualName).isEqualTo(expectedName);

    }

    @DisplayName("Car 인스턴스 우승자 여부 테스트")
    @Test
    void 승자() {
        // given
        String expected = "test3";
        Car car = new Car(expected);

        car.move(() -> true);
        boolean actual = car.isWinner(new Position(1));

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("Car 인스턴스 우승자 여부 테스트, 객체간의 비교")
    @Test
    void 승자_객체_비교() {
        // given
        String expected = "test4";
        Car car = new Car(expected);

        car.move(() -> true);
        boolean actual = car.isWinner(new Position(1));

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("Car 인스턴스의 포지션과 다른지 여부 테스트")
    @Test
    void 다른_포지션인지를_검증() {
        // given
        String testName = "test5";
        Car car = new Car(testName);
        Position position = new Position(0);

        // when
        car.move(() -> true);
        boolean actual = car.isDifferentPosition(position);

        // then
        assertThat(actual).isTrue();
    }

}