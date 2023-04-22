package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.strategyTest.GoMoveStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    @Test
    @DisplayName("자동차 객체 여러개 생성 되는지 확인")
    public void checkRacingCarsObject() {
        String[] test = new String[]{"pobi", "next", "step", "fight", "test"};
        RacingCars racingCars = new RacingCars(test);

        assertThat(racingCars.statusOfRacingCars()).hasSize(5);
    }

    @Test
    @DisplayName("racingCars 방어적 복사 확인")
    public void checkRacingCarsCopyObject() {
        String[] carList = new String[]{"pobi", "next", "step", "fight", "test"};
        List<RacingCar> originCarList = new ArrayList<>();

        for(String carName : carList) {
            originCarList.add(new RacingCar(carName));
        }

        RacingCars racingCars = new RacingCars(originCarList);
        List<RacingCar> racingCarList = racingCars.statusOfRacingCars();

        originCarList.add(new RacingCar("test5"));

        assertThat(originCarList.size()).isEqualTo(6);
        assertThat(racingCarList.size()).isEqualTo(5);

        //origin만 move
        for(int i = 0; i<carList.length; i++) {
            originCarList.get(i).tryToMove(new GoMoveStrategy());
        }
        // RacingCars 만 방어적 복사 RacingCar는 아님
        for(int i = 0; i<5; i++) {
            assertThat(originCarList.get(i).position()).isEqualTo(racingCarList.get(i).position());
        }
    }


}