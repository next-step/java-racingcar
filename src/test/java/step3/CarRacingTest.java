package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarRacingTest {

    @ParameterizedTest
    @ValueSource(strings = {"test,abc,macbook", "abcde,nextstep"})
    @DisplayName("자동차 이름이 5글자를 초과하는 경우 IllegalArgumentException가 발생한다.")
    void check_validate_carname_test(String carNameString) {
        assertThatThrownBy(() -> {
            new CarRacing(carNameString, 3);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 다섯 글자를 초과할 수 없습니다");

    }

    @ParameterizedTest
    @CsvSource(value = {"a,b:2", "test1,test2,test3:3"}, delimiter = ':')
    @DisplayName("racing 및 전진했을 때, 값이 증가하는지 테스트한다.")
    void doRacingStart(String carNameString, int expectedCount) {
        assertThatCode(() -> {
            //given
            CarRacing carRacing = new CarRacing(carNameString, 3);
            Cars cars = carRacing.racingGameStart().get(0);
            List<Car> racing = cars.getCars();
            int expected = racing.get(0).getMoveDistance() + 1;

            //when
            racing.get(0).moveForward(4);

            //then
            assertThat(racing.size()).isEqualTo(expectedCount);
            assertThat(racing.get(0).getMoveDistance()).isEqualTo(expected);
        }).doesNotThrowAnyException();
    }
}