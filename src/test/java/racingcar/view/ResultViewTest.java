package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.DefaultMovingStrategy;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {

    ResultView resultView;

    @BeforeEach
    void setUp() {
        resultView = new ResultView();
    }

    @Test
    @DisplayName("차의 이름과 위치를 출력")
    void printNameAndLocationTest() {
        // given
        Car testCar = new Car("testCar", new DefaultMovingStrategy());
        // when
        testCar.move(5);
        testCar.move(5);
        // then
        resultView = new ResultView();
        assertThat(resultView.printNameAndLocation(testCar)).isEqualTo("testCar: ---");
    }
}