package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    @DisplayName("경주 우승자 출력_1명")
    void printSingleWinnerTest() {
        // given
        Car testCar1 = new Car("testCar1", new DefaultMovingStrategy());
        Car testCar2 = new Car("testCar2", new DefaultMovingStrategy());
        Car testCar3 = new Car("testCar3", new DefaultMovingStrategy());
        Car testCar4 = new Car("testCar4", new DefaultMovingStrategy());
        Car testCar5 = new Car("testCar5", new DefaultMovingStrategy());
        // when
        testCar1.move(5);
        testCar1.move(5);
        testCar1.move(5);

        testCar2.move(5);

        testCar3.move(5);
        testCar3.move(5);

        testCar4.move(5);

        testCar5.move(5);

        List<Car> carList = List.of(testCar1, testCar2, testCar3, testCar4, testCar5);

        // then
        String winner = resultView.printWinner(carList);
        assertThat(winner).isEqualTo(testCar1.getCarName());
    }

    @Test
    @DisplayName("경주 우승자 출력_여러명")
    void printMultiWinnerTest() {
        // given
        Car testCar1 = new Car("testCar1", new DefaultMovingStrategy());
        Car testCar2 = new Car("testCar2", new DefaultMovingStrategy());
        Car testCar3 = new Car("testCar3", new DefaultMovingStrategy());
        Car testCar4 = new Car("testCar4", new DefaultMovingStrategy());
        Car testCar5 = new Car("testCar5", new DefaultMovingStrategy());
        // when
        testCar1.move(5);
        testCar1.move(5);
        testCar1.move(5);

        testCar2.move(5);
        testCar2.move(5);
        testCar2.move(5);

        testCar3.move(5);
        testCar3.move(5);
        testCar3.move(5);

        testCar4.move(5);
        testCar4.move(5);
        testCar4.move(5);

        testCar5.move(5);

        List<Car> carList = List.of(testCar1, testCar2, testCar3, testCar4, testCar5);

        // then
        String winner = resultView.printWinner(carList);
        assertThat(winner).isEqualTo("testCar1, testCar2, testCar3, testCar4");
    }

}