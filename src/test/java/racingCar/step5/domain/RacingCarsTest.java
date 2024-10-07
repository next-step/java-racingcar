package racingCar.step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    @DisplayName(",를 문자열을 분리하여 이름의 수만큼 차 생성이 가능하다")
    @Test
    void createCarWithNames(){
        RacingCars cars = RacingCars.ofNames("aa,bb,cc");
        assertThat(cars.countCars()).isEqualTo(3);
    }

    @DisplayName("가장 멀리간 차의 위치를 구할 수 있다")
    @Test
    void findMaxPosition(){
        List<RacingCar> cars = List.of(
                RacingCar.ofNameAndPosition("1등", 5)
                , RacingCar.ofNameAndPosition("2등", 4)
                , RacingCar.ofNameAndPosition("3등", 3)

        );
        RacingCars carGroup = RacingCars.ofCars(cars);

        assertThat(carGroup.maxPosition()).isEqualTo(5);
    }

    @DisplayName("동일한 위치에 있는 차들을 조회할 수 있다")
    @Test
    void samePositionCars(){
        List<RacingCar> cars = List.of(
                RacingCar.ofNameAndPosition("공동1등", 5)
                , RacingCar.ofNameAndPosition("공동2등", 5)
                , RacingCar.ofNameAndPosition("3등", 3)

        );
        RacingCars carGroup = RacingCars.ofCars(cars);

        assertThat(carGroup.samePosition(5)).hasSize(2);
        assertThat(carGroup.samePosition(5)).containsExactly(
                RacingCar.ofNameAndPosition("공동1등", 5)
                , RacingCar.ofNameAndPosition("공동2등", 5)
        );

    }
    
    @DisplayName("차들이 이동한다")
    @Test
    void moveCars() {
        RacingCars cars = RacingCars.ofNames("aa,bb,cc");

        cars.move(new RandomNumber(3));
        cars.move(new RandomNumber(4));
        cars.move(new RandomNumber(5));

        assertThat(cars.maxPosition()).isEqualTo(2);
    }




}
