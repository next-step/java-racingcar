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

    @DisplayName("자동차는 전진 조건이 4 이상일 때만 이동할 수 있다. 이동에 성공하면 자동차의 score는 1 이 된다.")
    @ParameterizedTest
    @CsvSource(value = {"4 : true,1", "3 : false,0", "5: true,1", "2 : false,0"}, delimiter = ':')
    public void carMoveConditionOnTrue(int condition, String expected) {
        //given
        MoveStrategy moveStrategy = new MoveStrategy(condition);
        Car car = new Car().move(moveStrategy);

        //when & then
        String[] splitExpected = expected.split(",");

        assertThat(moveStrategy.isMove())
                .isEqualTo(Boolean.parseBoolean(splitExpected[0]));

        assertThat(car.getScore())
                .isEqualTo(Integer.parseInt(splitExpected[1]));
    }


}
