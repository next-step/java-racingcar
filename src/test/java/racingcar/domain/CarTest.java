package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차를 생성할 수 있다.")
    @Test
    public void newCarWithNameTest() {
        //given
        Car car = new Car();

        //when & then
        assertThat(car).isNotNull();
    }

    @DisplayName("자동차는 전진 조건이 4 이상일 때만 이동할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"4 : true", "3 : false", "5: true", "2 : false"}, delimiter = ':')
    public void carMoveConditionOnTrue(int condition, boolean expected) {
        //given
        MoveStrategy moveStrategy = new MoveStrategy(condition);
        Car car = new Car().move(moveStrategy);

        //when & then
        assertThat(moveStrategy.isMove())
                .isEqualTo(expected); //splitExpected[0] = boolean
    }


}
