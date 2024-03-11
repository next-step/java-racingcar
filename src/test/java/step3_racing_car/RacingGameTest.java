package step3_racing_car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("운영자가 입력한 경주 대 수 만금 레이싱카가 생성된다.")
    @Test
    void countRacingCar(){
        RacingCars cars = new RacingCars(3);
        assertThat(cars.getRacingCars().size()).isEqualTo(3);
    }
    @DisplayName("초기 생성된 레이싱카의 위치는 0이다")
    @Test
    void racingCarDefaultPosition(){
        RacingCars cars = new RacingCars(3);
        for (int i = 0; i < cars.getRacingCars().size(); i++) {
            assertThat(cars.getRacingCars().get(i).getPosition()).isEqualTo(0);
        }
    }

    @DisplayName("한 레이싱카는 라운드마다 이동 거리만큼 이동한다.")
    @Test
    void movingRacingCar(){
        RacingCar car = new RacingCar();
        car.movePositions(1);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("모든 레이싱카는 라운드마다 이동 거리만큼 이동한다.")
    @Test
    void movingRacingCars(){
        RacingCars cars = new RacingCars(3);
        cars.movePosition(1);
        for (int i = 0; i < cars.getRacingCars().size(); i++) {
            assertThat(cars.getRacingCars().get(i).getPosition()).isEqualTo(1);
        }
    }

    @DisplayName("라운드가 진행되면 이동 전략에 따라 레이싱카가 이동된다 - forward 전략은 앞으로 1 전진")
    @Test
    void roundMovingRacingCars(){

        RacingCars cars = new RacingCars(3);
        GameRound round = new GameRound(cars);
        round.progressAllRound(1, new ForwardStrategy());

        for (int i = 0; i < cars.getRacingCars().size(); i++) {
            assertThat(cars.getRacingCars().get(i).getPosition()).isEqualTo(1);
        }
    }

    @DisplayName("라운드 count에 따라 레이싱카가 이동된다")
    @Test
    void roundsMovingRacingCars(){

        RacingCars cars = new RacingCars(3);
        GameRound round = new GameRound(cars);
        round.progressAllRound(5, new ForwardStrategy());

        for (int i = 0; i < cars.getRacingCars().size(); i++) {
            assertThat(cars.getRacingCars().get(i).getPosition()).isEqualTo(5);
        }

        // list / array 검증방법 2, 3
        assertThat(cars.getRacingCars()).allSatisfy(car -> assertThat(car.getPosition()).isEqualTo(5));
        assertThat(cars.getRacingCars()).extracting("position").contains(5);
    }
}
