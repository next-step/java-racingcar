package motorRace;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class MotorRaceApplicationTest {

    @Test
    @DisplayName("입력대로 RaceCar생성")
    void racingCarFactoryMakeRacingCarListTest(){
        RacingCarFactory racingCarFactory = new RacingCarFactory();
        int carCnt = 5;
        int expectedCarCnt = 5;

        RacingCars resultRacingCars = racingCarFactory.makeRacingCars(carCnt);
        assertThat(resultRacingCars.getRacingCarList()).hasSize(expectedCarCnt);
    }

    @Test
    @DisplayName("race실행 후 round수만큼 raceResult결과확인")
    void raceServiceRaceTest(){
        RaceService raceService = new RaceService();
        RacingCarFactory racingCarFactory = new RacingCarFactory();
        RacingCars racingCars = racingCarFactory.makeRacingCars(3);
        int moveCnt = 4;
        int expectedRaceResultSize = 4;

        RaceResult raceResult = raceService.race(racingCars,moveCnt);
        assertThat(raceResult.getRaceCarPostionResultList()).hasSize(expectedRaceResultSize);
    }

    @Test
    @DisplayName("MOVE_CONSTANT보다 높은 randomNumber가 주어지면 racingCar의 position은 증가")
    void raceCarMoveTest(){
        RacingCar racingCar = new RacingCar();
        int number = 5;
        int expectedPosition = 1;

        racingCar.move(number);

        assertThat(racingCar.getPosition()).isEqualTo(expectedPosition);
    }

    @Test
    @DisplayName("MOVE_CONSTANT보다 낮은 randomNumber가 주어지면 racingCar의 position은 그대로")
    void raceCarDontMoveTest(){
        RacingCar racingCar = new RacingCar();
        int number = 3;
        int expectedPosition = 0;

        racingCar.move(number);

        assertThat(racingCar.getPosition()).isEqualTo(expectedPosition);
    }
}
