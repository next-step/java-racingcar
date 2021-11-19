package study.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("생성자 정상 확인")
    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(strings = {"유재석",  "강호동", "나얼"})
    void 생성자_확인(String param) {
        assertThat(new Name(param)).isEqualTo(new Name(param));
    }

    @DisplayName("이름 정상 확인")
    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(strings = {"유재석",  "강호동", "나얼"})
    void 이름_확인(String param) {
        Car car = new Car(new Name(param));
        assertThat(car.getName()).isEqualTo(param);
    }

    @DisplayName("위치 정상 확인")
    @ParameterizedTest(name="{displayName} | 자동차이름: {0} | 위치: {1}")
    @CsvSource(value = {"유재석:3", "강호동:5", "나얼:7"}, delimiter = ':')
    void 위치_확인(String name, int position) {
        Car car = new Car(new Name(name), new Position(position));
        assertThat(car.getLocation().length()).isEqualTo(position);
    }

    @DisplayName("선두 위치 확인")
    @Test
    void 선두_위치_확인() {
        Car car = new Car(new Name("유재석"), new Position(3));
        assertThat(car.getMaxPosition(5)).isEqualTo(5);
    }

    @DisplayName("선두 위치 확인")
    @ParameterizedTest(name="{displayName} | 자동차이름: {0} | 위치: {1}")
    @CsvSource(value = {"유재석:3", "강호동:5", "나얼:7"}, delimiter = ':')
    void 선두_추월_확인(String name, int position) {
        Car car = new Car(new Name(name), new Position(position));
        assertThat(car.isWinnerPosition(position)).isTrue();
    }

}
