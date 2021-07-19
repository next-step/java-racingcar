package racingcar;

import org.assertj.core.api.Assertions;
import org.assertj.core.internal.Objects;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 정적_팩토리_테스트() throws Exception {
        // given
        Class<Car> expected = Car.class;

        // when
        Car actual = Car.of("siro", "-");

        // then
        Assertions.assertThat(actual).isNotNull().isInstanceOf(expected);
    }

    @Test
    void 위치_변경_테스트() throws Exception {
        // given
        int expectedLength = 2;
        String expectedPosition = "--";
        Car car = Car.of("siro", "-");

        // when
        Car actual = car.changePosition("-");

        // then
        Assertions.assertThat(actual.getPositionLength()).isEqualTo(expectedLength);
        Assertions.assertThat(actual.getPosition()).isEqualTo(expectedPosition);
    }

    @Test
    void 동일성_테스트() throws Exception {
        // given
        Car car1 = Car.of("siro", "-");
        Car car2 = car1;

        // when, then
        Assertions.assertThat(car1 == car2).isTrue();
        Assertions.assertThat(car1.equals(car2)).isTrue();
    }

    @Test
    void 동등성_테스트() throws Exception {
        // given
        Car car1 = Car.of("siro", "-");
        Car car2 = Car.of("siro", "-");

        // when, then
        Assertions.assertThat(car1.equals(car2)).isTrue();
    }

    @Test
    void 동등성_불일치_테스트() throws Exception {
        // given
        Car car = Car.of("siro", "-");

        // when, then
        Assertions.assertThat(car.equals(null)).isFalse();
        Assertions.assertThat(car.equals(Objects.instance())).isFalse();
    }

    @Test
    void 해시코드_테스트() throws Exception {
        // given
        Car car1 = Car.of("siro", "-");
        Car car2 = Car.of("siro", "-");

        // when
        int hash1 = car1.hashCode();
        int hash2 = car2.hashCode();

        // then
        Assertions.assertThat(hash1 == hash2).isTrue();
    }

    @Test
    void 이름_조회_테스트() throws Exception {
        // given
        String expected = "siro";
        Car car = Car.of(expected, "-");

        // when
        String actual = car.getName();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 위치_정보_조회_테스트() throws Exception {
        // given
        String expected = "-";
        Car car = Car.of("siro", expected);

        // when
        String actual = car.getPosition();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 현재_위치가_얼마나_긴지_조회_테스트() throws Exception {
        // given
        int expected = 3;
        Car car = Car.of("siro", "---");

        // when
        int actual = car.getPositionLength();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
