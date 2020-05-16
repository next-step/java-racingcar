package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.RacingDice;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.*;

class RacingTest {

    private final Dice defaultDice = new RacingDice(RacingDice.RACING_MAX_BOUND);

    @DisplayName("입력한 자동차의 수 만큼 Race 결과가 나오는 지 테스트")
    @Test
    public void joinRaceTest() {
        Racing race = new Racing(defaultDice, 3);
        int carCount = 10;
        race.joinRace(carCount);

        race.start(gameResults ->
                assertThat(gameResults.size()).isEqualTo(carCount));
    }

    @DisplayName("입력한 Race 시도 횟수만큼 race가 진행되는 지 테스트")
    @ParameterizedTest
    @CsvSource({"3", "4"})
    public void  raceGameSetCountTest(int racingCount) {
        AtomicInteger actualRacingCount = new AtomicInteger();
        Racing race = new Racing(defaultDice, racingCount);
        race.joinRace(3);

        race.start(carPositions -> actualRacingCount.getAndIncrement());

        assertThat(actualRacingCount.get()).isEqualTo(racingCount);
    }

    @DisplayName("0~3 의 Dice 숫자가 나왔을 때 전진을 안하는 지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void doNotMoveTest(int diceNumber) {
        Racing race = new Racing(() -> diceNumber,10 );
        int carCount = 3;
        race.joinRace(carCount);

        race.start(results -> {
            assertThat(results.stream().allMatch(result -> result == 0)).isTrue();
        });
    }

    @DisplayName("4~9 의 Dice 숫자가 나왔을 때 전진을 하는 지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7})
    public void moveTest(int diceNumber) {

        Racing race = new Racing(() -> diceNumber, 1);
        int carCount = 3;
        race.joinRace(carCount);

        race.start(results -> {
            assertThat(results.stream().allMatch(result -> result > 0)).isTrue();
        });
    }

    @DisplayName("race 진행 횟수가 1미만 일 경우 Exception 발생하는 지 테스트")
    @Test
    public void raceGameSetCountZeroTest() {
        Throwable throwable = catchThrowable(() -> {
            Racing race = new Racing(defaultDice, 0);
            race.start(System.out::println);
        });

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("전진하는 diceNumber가 나왔을 때 게임 횟수에 따라 누적되는 지 테스트")
    @Test
    public void moveSumTest() {
        Racing race = new Racing(() -> 9, 3);
        race.joinRace(3);

        AtomicInteger racedCount = new AtomicInteger();
        race.start(results -> {
            racedCount.getAndIncrement();
            assertThat(results.stream().allMatch(result -> result == racedCount.get())).isTrue();
        });
    }
}