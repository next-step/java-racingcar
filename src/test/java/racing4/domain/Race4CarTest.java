package racing4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Race4CarTest {
    @Test
    @DisplayName("차의 이름이 5자 초과일 경우 exception이 발생된다.")
    void validateRace4CarNameTest() {
        assertThrows(IllegalArgumentException.class,
                     () -> new Race4Car("레이싱카56"));
    }

    @Test
    @DisplayName("입력받은 carNames에 따른 리스트가 생성된다.")
    void makeCarsByTest() {
        String[] carNames = {"car1", "car2", "car3", "car4", "car5"};
        List<Race4Car> result = Race4Car.makeCarsBy(carNames);
        assertThat(result.size()).isEqualTo(5);
    }

    @ParameterizedTest
    @CsvSource({"3,false", "4,false", "5,true", "6,true"})
    @DisplayName("random 값이 4 초과여야 전진한다.")
    void moveForwardByConditionTest(int input, boolean expected) {
        Race4Car race4Car = new Race4Car("car");
        race4Car.moveForwardByCondition(input);
        assertThat(race4Car.getPosition() > 0).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0,false", "1,true"})
    void isMaxPositionTest(int input, boolean expected) {
        Race4Car race4Car = new Race4Car("car");
        race4Car.moveForwardByCondition(9);

        assertThat(race4Car.isMaxPosition(input)).isEqualTo(expected);
    }
}
