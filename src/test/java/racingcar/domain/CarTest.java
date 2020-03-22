package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

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

    @DisplayName("자동차는 전진 조건이 4 이상일 때만 이동할 수 있다. 전진하면 position이 1씩 증가한다.")
    @ParameterizedTest
    @CsvSource(value = {"4 : true,1", "3 : false,0", "5: true,1", "2 : false,0"}, delimiter = ':')
    public void carMoveConditionOnTrue(int condition, String expected) {
        //given
        MoveStrategy moveStrategy = new MoveStrategy(condition);
        Car car = new Car().move(moveStrategy);

        //when & then
        String[] splitExpected = expected.split(",");

        assertThat(moveStrategy.isMove())
                .isEqualTo(splitExpected[0]); //splitExpected[0] = boolean

        assertThat(car.getPosition())
                .isEqualTo(splitExpected[1]); //splitExpected[1] = int
    }

    @DisplayName("자동차는 전진하면 포지션이 1씩 증가한다.")
    @Test
    public void test() {
        //given
        MoveStrategy successStrategy = new MoveStrategy(5);
        MoveStrategy failStrategy = new MoveStrategy(3);

        Car car1 = new Car().move(successStrategy).move(successStrategy).move(successStrategy);
        Car car2 = new Car().move(successStrategy).move(failStrategy).move(failStrategy);
        Car car3 = new Car().move(failStrategy).move(failStrategy).move(failStrategy);

        //when & then
        assertThat(car1.getPosition()).isEqualTo(3);
        assertThat(car2.getPosition()).isEqualTo(1);
        assertThat(car3.getPosition()).isEqualTo(0);
    }


}
