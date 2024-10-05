package racingCar.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @DisplayName(",기준으로 자동차 이름을 입력하여 이름의 수만큼 자동차를 생성한다")
    @Test
    void createRacingCarsWithNames (){
        //given
        String carNames = "aa,bb,cc";
        //when
        RacingCars cars = RacingCars.ofNames("aa,bb,cc");
        //then
        assertThat(cars.getCars()).hasSize(3);
    }

    @DisplayName("차들이 이동한다")
    @Test
    void moveCars(){
        RacingCars cars = RacingCars.ofNames("aa,bb,cc");

        cars.move(new RandomNumber(3));
        cars.move(new RandomNumber(4));
        cars.move(new RandomNumber(5));

        assertThat(cars.getMaxCarPosition()).isEqualTo(2);
    }

    @DisplayName("차들 중 가장 멀리 이동한 차의 위치를 구할 수 있다")
    @Test
    void getMaxPositionByCars(){
        List<RacingCar> cars = List.of(
                RacingCar.ofNameAndPosition("1등", 5)
                , RacingCar.ofNameAndPosition("2등", 4)
                , RacingCar.ofNameAndPosition("3등", 3)

        );
        RacingCars carGroup = RacingCars.ofCars(cars);

        assertThat(carGroup.getMaxCarPosition()).isEqualTo(5);
    }

    @DisplayName("같은 위치의 차들 조회할 수 있다")
    @Test
    void findCarsByPosition(){
        List<RacingCar> cars = List.of(
                RacingCar.ofNameAndPosition("공동1등", 5)
                , RacingCar.ofNameAndPosition("공동1등", 5)
                , RacingCar.ofNameAndPosition("3등", 3)

        );
        RacingCars carGroup = RacingCars.ofCars(cars);

        assertThat(carGroup.findCarsByPosition(5)).hasSize(2);
        assertThat(carGroup.findCarsByPosition(5)).containsExactly(
                RacingCar.ofNameAndPosition("공동1등", 5)
                , RacingCar.ofNameAndPosition("공동1등", 5)
        );
    }

}