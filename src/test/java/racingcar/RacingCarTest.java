package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Name;
import racingcar.domain.Round;
import racingcar.service.Race;
import racingcar.util.RaceUtil;

import java.util.stream.IntStream;

public class RacingCarTest {

    @Nested
    class RaceUtilTest {
        @Test
        void 자동차가멈추는범위의수가생성되면_정지성공() {
            // when & then
            IntStream.rangeClosed(0, 3).forEach(i -> {
                assertThat(RaceUtil.determineCarMovement(i)).isFalse();
            });

        }

        @Test
        void 자동차가전진하는범위의수가생성되면_전진성공() {
            // when & then
            IntStream.rangeClosed(4, 9).forEach(i -> {
                assertThat(RaceUtil.determineCarMovement(i)).isTrue();
            });
        }
    }

    @Nested
    class CarTest {
        private Car car;
        private final String name = "pobi";

        @BeforeEach
        public void createCar() {
            car = Car.create(name);
        }

        @Test
        void 자동차생성할때_성공() {
            // when
            int position = car.getPosition();
            String name = car.getName();

            // then
            assertThat(position).isEqualTo(0);
            assertThat(name).isEqualTo(this.name);
        }

        @Test
        void 자동차전진요청할때_성공() {
            // given
            int beforePosition = car.getPosition();

            // when
            car.moveForward();

            // then
            assertThat(car.getPosition()).isEqualTo(beforePosition + 1);
        }
    }

    @Nested
    class RaceTest {
        @ParameterizedTest(name = "경주생성할때_성공[{arguments}]")
        @ValueSource(strings = {"pobi,crong,honux", "pobi"})
        void 경주생성할때_성공(String input) {
            // given
            int count = 5;
            Race race = createRace(input, count);

            // when & then
            assertThat(race.getLeftRound()).isEqualTo(count);
        }

        @ParameterizedTest(name = "경주진행할때_시행횟수차감성공[{arguments}]")
        @ValueSource(strings = {"pobi,crong,honux", "pobi"})
        void 경주진행할때_시행횟수차감성공(String input) {
            // given
            int beforeCount = 5;
            Race race = createRace(input, beforeCount);

            // when
            race.play(new FixedMovableStrategy(4));

            // then
            assertThat(race.getLeftRound()).isEqualTo(beforeCount - 1);
        }

        @ParameterizedTest(name = "경주진행할때_자동차전진성공[{arguments}]")
        @ValueSource(strings = {"pobi,crong,honux", "pobi"})
        void 경주진행할때_자동차전진성공(String input) {
            // given
            Race race = createRace(input, 5);

            // when & then
            race.play(new FixedMovableStrategy(4));
            for (Car car : race.getCars()) {
                assertThat(car.getPosition()).isEqualTo(1);
            }

            race.play(new FixedMovableStrategy(5));
            for (Car car : race.getCars()) {
                assertThat(car.getPosition()).isEqualTo(2);
            }
        }

        @ParameterizedTest(name = "경주진행할때_자동차정지성공[{arguments}]")
        @ValueSource(strings = {"pobi,crong,honux", "pobi"})
        void 경주진행할때_자동차정지성공(String input) {
            // given
            Race race = createRace(input, 5);

            // when & then
            race.play(new FixedMovableStrategy(0));
            for (Car car : race.getCars()) {
                assertThat(car.getPosition()).isEqualTo(0);
            }

            race.play(new FixedMovableStrategy(3));
            for (Car car : race.getCars()) {
                assertThat(car.getPosition()).isEqualTo(0);
            }
        }

        private Race createRace(String input, int leftRound) {
            String[] names = input.split(",");
            return Race.of(names, leftRound);
        }
    }

    @Nested
    class NameTest {
        @Test
        void 여섯자이상의이름이들어올때_생성실패_RuntimeException발생() {
            // when & then
            assertThatThrownBy(() -> Name.from("pobiii"))
                    .isInstanceOf(RuntimeException.class);
        }

        @Test
        void 이름이비었거나null일때_생성실패_RuntimeException발생() {
            // when & then
            assertThatThrownBy(() -> Name.from(""))
                    .isInstanceOf(RuntimeException.class);
            assertThatThrownBy(() -> Name.from(null))
                    .isInstanceOf(RuntimeException.class);
        }
    }

    @Nested
    class RoundTest {
        @ParameterizedTest(name = "시도횟수가0이하일때_실패_RuntimeException발생[{arguments}]")
        @ValueSource(ints = {0, -1})
        void 시도횟수가0이하일때_실패_RuntimeException발생(int totalRound) {
            // when & then
            assertThatThrownBy(() -> Round.from(totalRound))
                    .isInstanceOf(RuntimeException.class);
        }
    }
}
