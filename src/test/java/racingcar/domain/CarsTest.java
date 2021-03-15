package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {


    @Test
    @DisplayName("Cars getSize 테스트")
    void getSize() {
        //given
        final int carNumber = 5;
        Cars cars = new Cars(carNumber);

        //when
        int resultCarSize = cars.getSize();

        //then
        assertThat(resultCarSize).isEqualTo(carNumber);
    }

    @Test
    @DisplayName("자동차들을 움직이게 시켰을 때 움직임 전략에 따른 테스트")
    void moveCars() {
        //given
        final int carNumber = 3;
        Cars expectCars = new Cars(carNumber);
        MoveStrategy stubMoveStrategy = new StubMoveStrategy();
        for (int i = 0; i < carNumber; i++) {
            expectCars.getCars().get(i).move(true);
        }

        //when
        Cars resultCars = new Cars(carNumber);
        resultCars.moveCars(stubMoveStrategy);

        //then
        for (int i = 0; i < carNumber; i++) {
            Car resultCar = resultCars.getCars().get(i);
            Car expectCar = expectCars.getCars().get(i);
            assertThat(resultCar.getCurrentLocation()).isEqualTo(expectCar.getCurrentLocation());
        }
    }

    public class StubMoveStrategy implements MoveStrategy {
        @Override
        public Boolean getIsMove() {
            return true;
        }
    }


}
