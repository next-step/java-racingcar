package racingCar.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {
    
    private RacingCars cars;

    @DisplayName(",기준으로 자동차 이름을 입력하여 이름의 수만큼 자동차를 생성한다")
    @Test
    void createRacingCarsWithNames (){
        //given
        String carNames = "aa,bb,cc";
        //when
        cars = RacingCars.createCarsWithNames("aa,bb,cc");
        //then
        assertThat(cars.getCars()).hasSize(3);
    }

    @DisplayName("차들 중 가장 멀리 이동한 차의 위치를 구할 수 있다")
    @Test
    void getMaxPositionByCars(){
        //given, when
        raceCars(3, "aa,bb,cc");

        //then
        int maxPosition = cars.getCars().stream()
                            .mapToInt(RacingCar::getPosition)
                            .max()
                            .orElse(0);
        assertThat(cars.getMaxCarPosition()).isEqualTo(maxPosition);
    }

    @DisplayName("같은 위치의 차들 조회할 수 있다")
    void findCarsByPosition(){
        //given, when
        raceCars(5, "aa,bb,cc");

        //when, then
        List<RacingCar> samePositionCarsByStream = cars.getCars().stream()
                .filter(car -> car.getPosition() == 5)
                .collect(toList());

        List<RacingCar> samePositionByMethod = cars.findCarsByPosition(5);
        assertThat(samePositionByMethod).isEqualTo(samePositionCarsByStream);
    }

    private void raceCars(int racingCount, String carNames) {
        //given
        cars = RacingCars.createCarsWithNames(carNames);
        //when
        for (int i = 0; i < racingCount; i++) {
            cars.move();
        }
    }
}