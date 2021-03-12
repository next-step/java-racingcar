package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import step3.move.MoveStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 레이싱 라운드 컬렉션을 테스트
 */
class RacingResultTest {

    // 자동차 생성 시 움직임 전략을 설정
    private static MoveStrategy getMoveStrategy(boolean flag) {
        return () -> flag;
    }

    private static Stream<Arguments> carList() {
        return Stream.of(
                Arguments.of("user1", "user1"),
                Arguments.of("user2", "user2")
        );
    }

    private static Stream<Arguments> carPosition() {
        return Stream.of(
                Arguments.of("user1", true, 1),
                Arguments.of("user2", false, 0)
        );
    }

    private static Stream<Arguments> winnerEntry() {
        return Stream.of(
                Arguments.of(new Car(new Name("kim"), new Position(0), getMoveStrategy(true)), new Position(0), true),
                Arguments.of(new Car(new Name("seok"), new Position(3), getMoveStrategy(true)), new Position(3), true),
                Arguments.of(new Car(new Name("rae"), new Position(1), getMoveStrategy(true)), new Position(2), false)

        );
    }

    private static Stream<Arguments> findWinner() {
        Car car1 = new Car(new Name("a"), new Position(2), getMoveStrategy(true));
        Car car2 = new Car(new Name("win1"), new Position(3), getMoveStrategy(true));
        Car car3 = new Car(new Name("win2"), new Position(3), getMoveStrategy(true));
        return Stream.of(
                Arguments.of(Arrays.asList(car1, car2, car3), new String[] {"win1", "win2"})
        );
    }
    private static Stream<Arguments> findMaxPositionEntry() {
        Car car1 = new Car(new Name("a"), new Position(2), getMoveStrategy(true));
        Car car2 = new Car(new Name("win1"), new Position(3), getMoveStrategy(true));
        Car car3 = new Car(new Name("win2"), new Position(3), getMoveStrategy(true));
        Car car4 = new Car(new Name("win3"), new Position(5), getMoveStrategy(true));
        return Stream.of(
                Arguments.of(Arrays.asList(car1, car2, car3), new Position(3)),
                Arguments.of(Arrays.asList(car2, car3, car4), new Position(5))
        );
    }

    private RacingResult racingResult;

    @BeforeEach
    void setUp() {
        racingResult = new RacingResult();
    }

    @DisplayName("자동차 생성 테스트 -> 동일성, 동등성 테스트")
    @ParameterizedTest(name = "자동차 이름부여 생성 테스트 {0} == {1}")
    @MethodSource(value = "carList")
    void createdCarShouldNotNull(final String name, final String expected) {
        // given
        Car car = new Car(name);
        // when
        Name carName = car.getName();
        Name expectedName = new Name(expected);
        // then
        assertThat(carName).isEqualTo(expectedName);
        assertThat(carName.hashCode()).isEqualTo(expectedName.hashCode());
    }

    @DisplayName("move(): 자동차의 이동하는지 확인하는 테스트")
    @ParameterizedTest(name = "자동차({0})는 움직임 {1} 설정 시 Position{2}")
    @MethodSource(value = "carPosition")
    void moveCarPosition(final String name, final boolean moveFlag, final int position) {
        // given
        Car car = new Car(name, getMoveStrategy(moveFlag));
        // when
        car.move();
        Position carPosition = car.getPosition();
        // then
        assertThat(carPosition).isEqualTo(new Position(position));
    }

    @DisplayName("move(): 자동차의 연속적인 이동 위치를 확인 테스트")
    @ParameterizedTest(name = "자동차 이동 전략: {0}, position 값 : {1}")
    @CsvSource(value = {"user1, true, 2", "user2, false, 0"})
    void movesCarPosition(final String name, final boolean moveFlag, final int expected) {
        // given
        Car car = new Car(name, getMoveStrategy(moveFlag));
        // when
        car.move();
        car.move();
        Position carPosition = car.getPosition();
        // then
        assertThat(carPosition).isEqualTo(new Position(expected));
    }

    @DisplayName("isWinner(): 자동차 우승자 테스트")
    @ParameterizedTest(name = "해당 자동차가 우승 == {2}")
    @MethodSource(value = "winnerEntry")
    void carWinnerTest(final Car given, final Position maxPosition, final boolean expected) {
        // when
        boolean winner = given.isWinner(maxPosition);
        // then
        assertThat(winner).isEqualTo(expected);
    }

    @DisplayName("findWinners(): 자동차 우승자 여러명인 경우 테스트")
    @ParameterizedTest(name = "레이싱 엔트리 중 우승자 {1}")
    @MethodSource(value = "findWinner")
    void multiWinnerTest(List<Car> participantsEntry, String[] winners) {
        // given
        RacingRound racingRound = new RacingRound(participantsEntry);
        racingResult.addRacingRound(racingRound);
        // when
        String[] winner = racingResult.findWinners();
        // then
        assertThat(winner).containsExactly(winners);
    }

    @DisplayName(value = "getMaxPosition(): 최대 Position 테스트")
    @ParameterizedTest(name = "가장 멀리 간 자동차의 위치 {1}")
    @MethodSource(value = "findMaxPositionEntry")
    void testCase1(List<Car> participantsEntry, Position expected) {
        // given
        // when
        Position maxPosition = racingResult.getMaxPosition(participantsEntry);
        // then
        assertThat(maxPosition).isEqualTo(expected);
    }
}
