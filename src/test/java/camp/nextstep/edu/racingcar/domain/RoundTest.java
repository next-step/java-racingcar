package camp.nextstep.edu.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest implements CarNamesHelper, CarHelper, CarsHelper, RoundHelper {

    private CarNames validCarNames;

    @BeforeEach
    void setUp() {
        validCarNames = this.getValidCarNames();
        assertThat(validCarNames.size()).isEqualTo(3);
    }

    @DisplayName("주어진 자동차의 개수에 대해서 round 객체를 잘 생성하는지")
    @Test
    void constructor() {
        final Round round = Round.initialRoundFrom(validCarNames);
        assertThat(round).isNotNull();
        assertThat(round.getCars().size()).isEqualTo(3);
    }

    @DisplayName("자동차들을 이동시키면, 그 결과로 이루어진 새 round 객체를 리턴해야함")
    @Test
    void move() {
        // given
        final Round round = Round.initialRoundFrom(validCarNames);
        round.getCars().stream().forEach(
                car -> assertThat(car.getPosition().value()).isEqualTo(0)
        );
        // when
        final MovingStrategy moveOnlyStrategy = new MoveOnlyStrategy();
        final Round movedRound = round.move(moveOnlyStrategy);
        // then
        assertThat(movedRound).isNotNull();
        movedRound.getCars().stream().forEach(
                car -> assertThat(car.getPosition().value()).isEqualTo(1)
        );
    }

    @DisplayName("우승자를 잘 구하는지")
    @Test
    void getWinners() {
        // given
        final Car firstCar = this.createCar(CAR_NAME_FIRST, 1);
        final Car secondCar = this.createCar(CAR_NAME_SECOND, 2);
        final Car thirdCar = this.createCar(CAR_NAME_THIRD, 3);
        final Cars cars = this.createCars(firstCar, secondCar, thirdCar);
        final Round round = this.createRound(cars);
        // when
        final CarNames carNames = round.getWinners();
        // then
        assertThat(carNames).isNotNull();
        assertThat(carNames.size()).isEqualTo(1);
        assertThat(carNames.stream()
                .anyMatch(name -> name.equals(CAR_NAME_THIRD))).isTrue();
    }

    @DisplayName("우승자가 여러명일 때 잘 구하는지")
    @Test
    void getWinnersWhenNumberOfWinnersAreGreaterThanOne() {
        // given
        final Car firstCar = this.createCar(CAR_NAME_FIRST, 3);
        final Car secondCar = this.createCar(CAR_NAME_SECOND, 3);
        final Car thirdCar = this.createCar(CAR_NAME_THIRD, 3);
        final Cars cars = this.createCars(firstCar, secondCar, thirdCar);
        final Round round = this.createRound(cars);
        // when
        final CarNames carNames = round.getWinners();
        // then
        assertThat(carNames.size()).isEqualTo(3);
        assertThat(carNames.stream()
                .anyMatch(name -> name.equals(CAR_NAME_FIRST))).isTrue();
        assertThat(carNames.stream()
                .anyMatch(name -> name.equals(CAR_NAME_SECOND))).isTrue();
        assertThat(carNames.stream()
                .anyMatch(name -> name.equals(CAR_NAME_THIRD))).isTrue();
    }
}