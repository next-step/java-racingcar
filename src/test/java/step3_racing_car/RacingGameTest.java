package step3_racing_car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("RacingCar test - 한 레이싱카는 라운드마다 이동 거리만큼 이동한다.")
    @Test
    void movingRacingCar() {
        String name = "참가자";
        RacingCar car = new RacingCar(name);
        car.movePositions(1);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("RacingCars test - 운영자가 입력한 이름 수 만큼 레이싱카가 생성된다.")
    @Test
    void racingCarsCount() {
        List<String> carNames = List.of("참가자1", "참가자2", "참가자3");
        RacingCars cars = new RacingCars(carNames);
        assertThat(cars.getRacingCars().size()).isEqualTo(3);
    }

    @DisplayName("RacingCars test - 운영자가 입력한 이름이 잘 반영된다.")
    @Test
    void racingCarNames() {
        List<String> carNames = List.of("참가자1", "참가자2", "참가자3");
        RacingCars cars = new RacingCars(carNames);
        List<String> savedNames = cars.getRacingCars()
                .stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());
        assertThat(savedNames.containsAll(carNames));
    }

    @DisplayName("RacingCars test - 초기 생성된 레이싱카들의 위치는 0이다")
    @Test
    void racingCarDefaultPosition() {
        List<String> carNames = List.of("참가자1", "참가자2", "참가자3");
        RacingCars cars = new RacingCars(carNames);
        for (int i = 0; i < cars.getRacingCars().size(); i++) {
            assertThat(cars.getRacingCars().get(i).getPosition()).isEqualTo(0);
        }
    }

    @DisplayName("RacingCars test - 모든 레이싱카는 라운드마다 이동 거리만큼 이동한다.")
    @Test
    void movingRacingCars() {
        List<String> carNames = List.of("참가자1", "참가자2", "참가자3");
        RacingCars cars = new RacingCars(carNames);
        cars.movePosition(new ForwardStrategy());
        for (int i = 0; i < cars.getRacingCars().size(); i++) {
            assertThat(cars.getRacingCars().get(i).getPosition()).isEqualTo(1);
        }
    }

    @DisplayName("RacingCars test - 가장 먼 거리를 간 자동차가 우승한다. forward 전략에서는 모두 우승자다.")
    @Test
    void winnerOfRacingCars() {

        List<String> carNames = List.of("참가자1", "참가자2", "참가자3");
        RacingCars cars = new RacingCars(carNames);
        GameRound round = new GameRound(cars);
        round.progressAllRound(5, new ForwardStrategy());
        List<String> savedNames = cars.getRacingCars()
                .stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());

        assertThat(savedNames).containsAll(carNames);
    }

    @DisplayName("GameRound test - 라운드가 진행되면 이동 전략에 따라 레이싱카가 이동된다. forward 전략은 앞으로 1 전진")
    @Test
    void roundMovingRacingCars() {

        List<String> carNames = List.of("참가자1", "참가자2", "참가자3");
        RacingCars cars = new RacingCars(carNames);
        GameRound round = new GameRound(cars);
        round.progressAllRound(1, new ForwardStrategy());

        for (int i = 0; i < cars.getRacingCars().size(); i++) {
            assertThat(cars.getRacingCars().get(i).getPosition()).isEqualTo(1);
        }
    }

    @DisplayName("GameRound test - 라운드 count에 따라 레이싱카가 이동된다")
    @Test
    void roundsMovingRacingCars() {

        List<String> carNames = List.of("참가자1", "참가자2", "참가자3");
        RacingCars cars = new RacingCars(carNames);
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
