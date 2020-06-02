package racingcar_step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar_step4.domain.Cars;
import racingcar_step4.model.Car;
import racingcar_step4.view.InputView;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("초간단 자동차 경주 테스트 - Cars 클래스")
public class CarsTest {

    @Test
    @DisplayName("Test1 자동차 이동")
    void carMoveOne() {
        Car car = new Car("car");
        car.move();
        int moveDistance = car.getTotalDistance();

        if(moveDistance >= 1 ) {
            assertThat(moveDistance).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("Test2 자동차 정지")
    void carNotMove() {
        Car car = new Car("car");
        car.move();
        int moveDistance = car.getTotalDistance();

        if(moveDistance <= 0 ) {
            assertThat(moveDistance).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("Test3 자동차 랭킹")
    public void carRankTest() {
        List<Car> cars = Arrays.asList(new Car("car1", 3)
                , new Car("car2", 2)
                , new Car("car3", 5));

        Cars racingRank = new Cars();
        List<Car> winners = racingRank.rankCars(cars);

        assertThat(winners).hasSize(1);
        assertThat(winners).containsExactly(cars.get(0));
    }

    @Test
    @DisplayName("Test4 자동차 이름 정규식 오류")
    public void checkPatternTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputView.checkPattern(",car2,car3");
        });
    }
}
