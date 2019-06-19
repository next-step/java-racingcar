package camp.nextstep.edu.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RoundsTest implements CarNamesHelper, CarHelper, CarsHelper, RoundHelper {

    private CarNames validCarNames;

    @BeforeEach
    void setUp() {
        validCarNames = this.getValidCarNames();
        assertThat(validCarNames).hasSize(3);
    }

    @DisplayName("emptyInstance 팩터리 메서드는 비어있는 Rounds 객체를 생성해야함")
    @Test
    void constructor() {
        final Rounds rounds = Rounds.empty();
        assertThat(rounds).isNotNull();
        assertThat(rounds).hasSize(0);
    }

    @DisplayName("round 객체가 잘 추가되어야함")
    @Test
    void add() {
        // given
        final Round first = Round.initialRoundFrom(validCarNames);
        final Round second = first.move(() -> 1);
        final Round third = second.move(() -> 1);

        final Rounds rounds = Rounds.empty();
        assertThat(rounds).hasSize(0);
        // when 1
        rounds.add(first);
        // then 1
        assertThat(rounds).hasSize(1);

        // when 2
        rounds.add(second);
        // then 2
        assertThat(rounds).hasSize(2);

        // when 3
        rounds.add(third);
        // then 3
        assertThat(rounds).hasSize(3);
    }

    @DisplayName("null 을 추가하는 경우 IllegalArgumentException 예외 발생")
    @Test
    void failToAddWhenArgumentIsNull() {
        // given
        final Rounds rounds = Rounds.empty();
        assertThat(rounds).hasSize(0);
        // when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> rounds.add(null))
                // then 1
                .withMessageContaining("must not be null");
        // then 2
        assertThat(rounds).hasSize(0); // 에러가 발생해도 원본 객체에는 영향이 없어야함
    }

    @DisplayName("마지막 아이템을 잘 돌려주어야함")
    @Test
    void getLast() {
        // given
        final Rounds rounds = Rounds.empty();
        final Round first = Round.initialRoundFrom(validCarNames);
        final Round second = first.move(() -> 1);
        final Round last = second.move(() -> 1);
        rounds.add(first);
        rounds.add(second);
        rounds.add(last);
        assertThat(rounds).hasSize(3);
        // when
        final Round actual = rounds.getLast().orElseThrow(AssertionFailedError::new);
        // then
        assertThat(actual).isSameAs(last);
    }

    @DisplayName("컬렉션이 비어있을 때 마지막 아이템에 접근하면, 빈 Optional 을 리턴해야함")
    @Test
    void getLastReturnsOptionalEmptyWhenInnerCollectionIsEmpty() {
        // given
        final Rounds rounds = Rounds.empty();
        // when
        final Optional<Round> actual = rounds.getLast();
        // then
        assertThat(actual).isEmpty();
    }

    @DisplayName("마지막 라운드의 우승자를 잘 구하는지")
    @Test
    void getWinnersOfLastRound() {
        // given
        final Car firstCar = this.createCar(CAR_NAME_FIRST, 1);
        final Car secondCar = this.createCar(CAR_NAME_SECOND, 2);
        final Car thirdCar = this.createCar(CAR_NAME_THIRD, 3);
        final Cars cars = this.createCars(firstCar, secondCar, thirdCar);
        final Round round = this.createRound(cars);
        final Rounds rounds = Rounds.empty();
        rounds.add(round);
        // when
        final CarNames carNames = rounds.getWinnersOfLastRound();
        // then
        assertThat(carNames).hasSize(1);
        assertThat(carNames).anyMatch(name -> name.equals(CAR_NAME_THIRD));
    }

    @DisplayName("rounds 가 비어있을 때, 우승자를 구하려고 하면 비어있는 CarNames 을 리턴해야함")
    @Test
    void getWinnersOfLastRoundReturnsEmptyCarNamesWhenRoundIsEmpty() {
        // given
        final Rounds rounds = Rounds.empty();
        // when
        final CarNames carNames = rounds.getWinnersOfLastRound();
        // then
        assertThat(carNames).hasSize(0);
    }
}