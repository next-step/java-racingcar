package racingcar.race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.DiceRacingRule;
import racingcar.RacingDice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class RacingTest {

    private final Dice DEFAULT_DICE = RacingDice.newInstance();
    private final RacingRule DEFAULT_RACING_RULE = new DiceRacingRule(DEFAULT_DICE);

    private List<Car> defaultCarList;

    @BeforeEach
    public void setUp() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("test1"));
        carList.add(new Car("test2"));
        carList.add(new Car("test3"));
        carList.add(new Car("test4"));
        defaultCarList = carList;
    }

    @DisplayName("입력한 자동차의 이름만큼 Race 결과가 나오는 지 테스트")
    @Test
    public void joinRaceTest() {
        Racing race = Racing.applyRacing(DEFAULT_RACING_RULE, defaultCarList, 3);

        race.start(gameResults ->
                assertThat(gameResults.size()).isEqualTo(defaultCarList.size()));
    }

    @DisplayName("입력한 Race 시도 횟수만큼 race가 진행되는 지 테스트")
    @ParameterizedTest
    @CsvSource({"3", "4"})
    public void  raceGameSetCountTest(int racingCount) {
        AtomicInteger actualRacingCount = new AtomicInteger();
        Racing race = Racing.applyRacing(defaultCarList, racingCount);

        race.start(carPositions -> actualRacingCount.getAndIncrement());

        assertThat(actualRacingCount.get()).isEqualTo(racingCount);
    }

    @DisplayName("0~3 의 Dice 숫자가 나왔을 때 전진을 안하는 지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void doNotMoveTest(int diceNumber) {
        RacingRule racingRule = new DiceRacingRule(() -> diceNumber);
        Racing race = Racing.applyRacing(racingRule, defaultCarList, 10 );

        race.start(results -> {
            assertThat(results.stream().allMatch(result -> result.getPosition() == 0)).isTrue();
        });
    }

    @DisplayName("4~9 의 Dice 숫자가 나왔을 때 전진을 하는 지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7})
    public void moveTest(int diceNumber) {
        RacingRule racingRule = new DiceRacingRule(() -> diceNumber);
        Racing race = Racing.applyRacing(racingRule, defaultCarList,1);

        race.start(results -> {
            assertThat(results.stream().allMatch(result -> result.getPosition() > 0)).isTrue();
        });
    }

    @DisplayName("race 진행 횟수가 1미만 일 경우 Exception 발생하는 지 테스트")
    @Test
    public void raceGameSetCountZeroTest() {
        Throwable throwable = catchThrowable(() -> {
            Racing race = Racing.applyRacing(DEFAULT_RACING_RULE, defaultCarList, 0);
            race.start(System.out::println);
        });

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("전진하는 diceNumber가 나왔을 때 게임 횟수에 따라 누적되는 지 테스트")
    @Test
    public void moveSumTest() {
        RacingRule racingRule = new DiceRacingRule(() -> 9);
        Racing race = Racing.applyRacing(racingRule, defaultCarList, 3);
        AtomicInteger racedCount = new AtomicInteger();

        race.start(results -> {
            racedCount.getAndIncrement();
            assertThat(results.stream().allMatch(result -> result.getPosition() == racedCount.get())).isTrue();
        });
    }

    @DisplayName("우승자가 제대로 리턴되는지 테스트")
    @Test
    public void getWinnerAfterFinalRacingTest() {
        Racing racing = Racing.applyRacing(() -> 1, getDefaultCarListWinnerTest(), 1);
        racing.start(racingScorecards -> {});
        List<RacingScoreCard> list = racing.getWinner();

        List<String> winnerNames = list.stream().map(RacingScoreCard::getName).collect(Collectors.toList());
        assertThat(winnerNames.size()).isEqualTo(2);
        assertThat(winnerNames).contains("TEST03", "TEST04");

    }

    private List<Car> getDefaultCarListWinnerTest() {
        List<Car> testCarList = new ArrayList<>();
        testCarList.add(new Car("TEST01"));
        testCarList.add(new Car("TEST02"));
        Car winnerCar1 = new Car("TEST03");
        Car winnerCar2 = new Car("TEST04");
        winnerCar1.drive(5);
        winnerCar2.drive(5);
        testCarList.add(winnerCar1);
        testCarList.add(winnerCar2);
        return testCarList;
    }
}