package motorRace;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class MotorRaceApplicationTest {

    @Test
    @DisplayName("입력대로 RaceCar생성")
    void makeRacingCarsTest(){
        int carCnt = 5;
        List<RacingCar> racingCarList = new ArrayList<>();

        int expectedCarCnt = 5;

        List<RacingCar> resultRacingCarList = MotorRaceApplication.makeRacingCars(racingCarList,carCnt);
        assertThat(resultRacingCarList).hasSize(expectedCarCnt);
    }

    @Test
    @DisplayName("constantValue보다 높은 수는 move")
    void conditionTest(){
        RacingCar racingCar = new RacingCar();
        int randomValue = 5;
        int constantValue = 3;

        int expectedCarCnt = 1;

        RacingCar resultRacingCar = MotorRaceApplication.condition(racingCar,randomValue,constantValue);

        assertThat(resultRacingCar.getPosition()).isEqualTo(expectedCarCnt);
    }

    @Test
    @DisplayName("constantValue보다 낮은 수는 dont move")
    void conditionTest2(){
        RacingCar racingCar = new RacingCar();
        int randomValue = 3;
        int constantValue = 5;

        int expectedCarCnt = 0;

        RacingCar resultRacingCar = MotorRaceApplication.condition(racingCar,randomValue,constantValue);

        assertThat(resultRacingCar.getPosition()).isEqualTo(expectedCarCnt);
    }
}
