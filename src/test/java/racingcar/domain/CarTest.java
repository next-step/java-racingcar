package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "     "})
    void 자동차_이름_빈문자열_스페이스(String name) {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new Car(name))
            .withMessageMatching("빈 문자열은 자동차 이름으로 지정할 수 없습니다.");
    }

    @Test
    void 자동차_이름_널() {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new Car(null))
            .withMessageMatching("빈 문자열은 자동차 이름으로 지정할 수 없습니다.");
    }

    @Test
    void 자동차_이름_5글자초과() {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new Car("daniel"))
            .withMessageMatching("자동차 이름은 5글자를 넘길 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi","한글이름ㅇ", "12345", "ㅇㅇㅇㅇㅇ", "_____", "$$$$$", "1ㄱ$ ㅠ", " 1234"})
    void 자동차_이름_5글자이하(String name) {
        assertAll(
            () -> assertThat(new Car(name).name()).isEqualTo(name),
            () -> assertThat(new Car(name).position()).isEqualTo(Car.SET_POSITION)
        );
    }

    @Test
    void 자동차_클론() {
        Car car = new Car("이름");

        car.move();
        Car clone = car.clone();

        assertAll(
            () -> assertThat(clone).isNotSameAs(car),
            () -> assertThat(clone.position()).isEqualTo(car.position()),
            () -> assertThat(clone.name()).isEqualTo(car.name())
        );
    }

    @Test
    void 자동차_움직임() {
        Car car = new Car();
        car.move();
        assertThat(car.position()).isEqualTo(Car.SET_POSITION + 1);
    }

    @Test
    void 자동차_초기화() {
        assertAll(
            () -> assertThat(new Car().position()).isEqualTo(Car.SET_POSITION),
            () -> assertThat(new Car().name()).isNotBlank()
        );
    }

}
