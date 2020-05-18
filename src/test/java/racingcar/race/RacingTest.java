package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.DiceRacingRule;
import racingcar.RacingDice;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class RacingTest {

    private final Dice DEFAULT_DICE = RacingDice.newInstance();
    private final RacingRule DEFAULT_RACING_RULE = new DiceRacingRule(DEFAULT_DICE);
    private final int DEFAULT_CAR_COUNT = 10;

    @DisplayName("입력한 자동차의 수 만큼 Race 결과가 나오는 지 테스트")
    @Test
    public void joinRaceTest() {
        int carCount = 10;
        Racing race = new Racing(DEFAULT_RACING_RULE, DEFAULT_CAR_COUNT, 3);

        race.start(gameResults ->
                assertThat(gameResults.size()).isEqualTo(carCount));
    }

    @DisplayName("입력한 Race 시도 횟수만큼 race가 진행되는 지 테스트")
    @ParameterizedTest
    @CsvSource({"3", "4"})
    public void  raceGameSetCountTest(int racingCount) {
        AtomicInteger actualRacingCount = new AtomicInteger();
        Racing race = new Racing(DEFAULT_RACING_RULE, DEFAULT_CAR_COUNT, racingCount);

        race.start(carPositions -> actualRacingCount.getAndIncrement());

        assertThat(actualRacingCount.get()).isEqualTo(racingCount);
    }

    @DisplayName("0~3 의 Dice 숫자가 나왔을 때 전진을 안하는 지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void doNotMoveTest(int diceNumber) {
        RacingRule racingRule = new DiceRacingRule(() -> diceNumber);
        Racing race = new Racing(racingRule, DEFAULT_CAR_COUNT, 10 );

        race.start(results -> {
            assertThat(results.stream().allMatch(result -> result == 0)).isTrue();
        });
    }

    @DisplayName("4~9 의 Dice 숫자가 나왔을 때 전진을 하는 지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7})
    public void moveTest(int diceNumber) {
        RacingRule racingRule = new DiceRacingRule(() -> diceNumber);
        Racing race = new Racing(racingRule, DEFAULT_CAR_COUNT,1);

        race.start(results -> {
            assertThat(results.stream().allMatch(result -> result > 0)).isTrue();
        });
    }

    @DisplayName("race 진행 횟수가 1미만 일 경우 Exception 발생하는 지 테스트")
    @Test
    public void raceGameSetCountZeroTest() {
        Throwable throwable = catchThrowable(() -> {
            Racing race = new Racing(DEFAULT_RACING_RULE, DEFAULT_CAR_COUNT, 0);
            race.start(System.out::println);
        });

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("전진하는 diceNumber가 나왔을 때 게임 횟수에 따라 누적되는 지 테스트")
    @Test
    public void moveSumTest() {
        RacingRule racingRule = new DiceRacingRule(() -> 9);
        Racing race = new Racing(racingRule, DEFAULT_CAR_COUNT, 3);
        AtomicInteger racedCount = new AtomicInteger();

        race.start(results -> {
            racedCount.getAndIncrement();
            assertThat(results.stream().allMatch(result -> result == racedCount.get())).isTrue();
        });
    }
}