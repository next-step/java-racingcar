package racingcar.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Position;
import racingcar.dto.RaceRequest;
import racingcar.test.FixedMovableStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class RaceTest {

    @Test
    void Race생성시_성공() {
        // when & then
        assertThatNoException().isThrownBy(() -> createRace("a,b,c", 5, true));
    }
    
    @Test
    void play할때_leftRound감소성공() {
        // given'
        final Race race = createRace("a,b,c", 5, true);
        final int beforeRound = race.getLeftRound().getValue();

        // when
        race.play();
        
        // then
        assertThat(race.getLeftRound().getValue()).isEqualTo(beforeRound - 1);
    }

    @ParameterizedTest(name = "경주진행할때_자동차전진성공[{arguments}]")
    @ValueSource(strings = {"pobi,crong,honux", "pobi"})
    void 경주진행할때_자동차전진성공(String input) {
        // given
        Race race = createRace(input, 5, true);

        // when & then
        race.play();
        for (Car car : race.getCars().getCars()) {
            assertThat(car.getPosition()).isEqualTo(Position.from(1));
        }

        race.play();
        for (Car car : race.getCars().getCars()) {
            assertThat(car.getPosition()).isEqualTo(Position.from(2));
        }
    }

    @ParameterizedTest(name = "경주진행할때_자동차정지성공[{arguments}]")
    @ValueSource(strings = {"pobi,crong,honux", "pobi"})
    void 경주진행할때_자동차정지성공(String input) {
        // given
        Race race = createRace(input, 5, false);

        // when & then
        race.play();
        for (Car car : race.getCars().getCars()) {
            assertThat(car.getPosition()).isEqualTo(Position.from());
        }

        race.play();
        for (Car car : race.getCars().getCars()) {
            assertThat(car.getPosition()).isEqualTo(Position.from());
        }
    }

    private Race createRace(String input, int leftRound, boolean isCarsStop) {
        return Race.create(new RaceRequest(input, String.valueOf(leftRound)), new FixedMovableStrategy(isCarsStop));
    }
}
