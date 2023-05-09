package racingcar.domain.game;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.game.dto.CarDto;
import racingcar.domain.random.RangeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class RacingGameTest {

    private final int numbOfTrial = 2;
    private final String racingCarName = "abc";

    private RacingGame game;

    @BeforeEach
    void setUp() {
        game = new RacingGame(numbOfTrial,
                List.of(racingCarName),
                new RangeRandomNumberGenerator(0, 9));
    }

    @Test
    void 시도횟수_만큼_게임을_실행할수있다() {
        int runCount = 0;

        for (int i = 0; i < numbOfTrial; i++) {
            game.runOnce();
            runCount++;
        }

        Assertions.assertThat(runCount).isEqualTo(numbOfTrial);
    }

    @Test
    void 시도횟수_만큼_게임을_진행하면_더이상_진행할수없다() {
        runGameNumberOf(this.numbOfTrial);

        Assertions.assertThatExceptionOfType(GameException.class)
                .isThrownBy(() -> game.runOnce());
    }

    @Test
    void 게임을_1회_실행하면_실행결과_자동차_상태를담은_컬렉션을_반환한다() {
        List<CarDto> carDTOs = game.runOnce().getCars();

        Assertions.assertThat(carDTOs)
                .haveAtLeastOne(carNamed(racingCarName));
    }

    @Test
    void 종료된_게임인지_알려준다() {
        runGameNumberOf(this.numbOfTrial);

        Assertions.assertThat(game.isEnded()).isTrue();
    }

    @Test
    void 현재까지의_우승자를_알려준다() {
        runGameNumberOf(this.numbOfTrial - 1);

        Assertions.assertThat(game.winnerCars().getCars())
                .haveAtLeastOne(carNamed(racingCarName));
    }

    @Test
    void 비어있는_리스트의_각_원소를_매핑하여_리스트로_생성하는경우_비어있는_리스트가_생성된다() {
        List<Car> emptyCars = new ArrayList<>();

        List<String> collectionExpectedToBeEmpty = emptyCars.stream()
                .map(car -> car.name().value())
                .collect(Collectors.toList());

        Assertions.assertThat(collectionExpectedToBeEmpty).isEmpty();
    }

    private void runGameNumberOf(int n) {
        int trial = this.numbOfTrial > n ? n : this.numbOfTrial;

        for (int i = 0; i < trial; i++) {
            game.runOnce();
        }
    }

    private Condition<CarDto> carNamed(String name) {
        return new Condition<>(
                carDto -> carDto.getName().equals(name),
                "has name " + name
        );
    }
}
