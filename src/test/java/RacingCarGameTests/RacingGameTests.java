package RacingCarGameTests;

import domain.RacingCarPosition;
import domain.RacingGame;
import domain.RacingGameResult;
import domain.RacingRound;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@DisplayName("레이싱 게임 테스트")
public class RacingGameTests {

    private static final String[] testRacingCarNames = new String[]{"sonata", "sorento", "tesla"};

    @DisplayName("레이싱 게임 생성 테스트")
    @ParameterizedTest
    @MethodSource("generateRacingGameTestCases")
    public void generateRacingGameTest(String[] carNames, int roundNumber) {
        assertThatCode(() -> RacingGame.create(carNames, roundNumber)).doesNotThrowAnyException();
    }

    @DisplayName("레이싱 게임 생성 테스트 - 차 대수 비정상 케이스")
    @ParameterizedTest
    @MethodSource("generateRacingGameAbnormalCarNumberTestCases")
    public void generateRacingGameAbnormalCarNumberTest(String[] carNames, int roundNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RacingGame.create(carNames, roundNumber))
                .withMessageMatching("car number must be greater than zero.");
    }

    @DisplayName("레이싱 게임 생성 테스트 - 차 이름 비정상 케이스")
    @ParameterizedTest
    @MethodSource("generateRacingGameAbnormalCarNamesTestCases")
    public void generateRacingGameAbnormalCarNamesTest(String[] carNames, int roundNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RacingGame.create(carNames, roundNumber))
                .withMessageMatching("car names contains abnormal name.");
    }

    @DisplayName("레이싱 게임 생성 테스트 - 라운드 갯수 비정상 케이스")
    @ParameterizedTest
    @ValueSource(ints = {-4, -3, -1})
    public void generateRacingGameAbnormalRoundNumberTest(int roundNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RacingGame.create(testRacingCarNames, roundNumber))
                .withMessageMatching("round number must be greater than zero.");
    }

    @DisplayName("레이싱 게임 결과 테스트")
    @ParameterizedTest
    @MethodSource("startRacingGameTestCases")
    public void startRacingGameTest(String[] carNames, int roundNumber) {
        RacingGame racingGame = RacingGame.create(carNames, roundNumber);
        RacingGameResult racingGameResult = racingGame.start();
        List<List<Integer>> positionResult = racingGameResult.getResult();
        String[] winners = racingGameResult.getWinners();

        assertThat(positionResult).hasSize(roundNumber);
        positionResult.stream()
                .forEach(round -> assertRound(round));
        assertThat(winners.length).isGreaterThanOrEqualTo(0);
    }

    @DisplayName("레이싱 게임 결과 - 우승자 테스트")
    @ParameterizedTest
    @MethodSource("racingGameWinnerTestCases")
    @ExtendWith(MockitoExtension.class)
    public void racingGameWinnerTest(List<RacingRound> racingRounds, String[] expectedWinners) {
        RacingGame racingGame = mock(RacingGame.class);
        given(racingGame.start()).willReturn(new RacingGameResult(racingRounds));
        RacingGameResult racingGameResult = racingGame.start();
        String[] winners = racingGameResult.getWinners();

        assertThat(winners).isEqualTo(expectedWinners);
    }

    private void assertRound(List<Integer> round) {
        round.stream()
                .forEach(position -> assertThat(position).isGreaterThanOrEqualTo(0));
    }

    private static Stream<Arguments> generateRacingGameTestCases() {
        return Stream.of(
                Arguments.of(new String[]{"sonata", "sorento", "tesla", "truck", "bike"}, 3),
                Arguments.of(new String[]{"sonata", "sorento", "tesla"}, 6),
                Arguments.of(new String[]{"sonata", "sorento", "tesla", "truck", "bike", "foot", "fly"}, 4)
        );
    }

    private static Stream<Arguments> generateRacingGameAbnormalCarNumberTestCases() {
        return Stream.of(
                Arguments.of(new String[]{}, 3),
                Arguments.of(null, 2)
        );
    }

    private static Stream<Arguments> generateRacingGameAbnormalCarNamesTestCases() {
        return Stream.of(
                Arguments.of(new String[]{"", "abc", "test"}, 3),
                Arguments.of(new String[]{" ", "abc", "test"}, 1)
        );
    }

    private static Stream<Arguments> startRacingGameTestCases() {
        return Stream.of(
                Arguments.of(new String[]{"sonata", "sorento", "tesla", "truck"}, 1),
                Arguments.of(new String[]{"truck", "bike", "sonata", "sorento", "tesla"}, 0),
                Arguments.of(new String[]{"sonata", "sorento", "tesla", "truck", "bike", "foot", "fly"}, 4)
        );
    }

    private static Stream<Arguments> racingGameWinnerTestCases() {
        return Stream.of(
                Arguments.of(new ArrayList<>(Arrays.asList(
                        RacingRound.newInstance(new RacingCarPosition[]{
                                new RacingCarPosition("sonata", 0),
                                new RacingCarPosition("sorento", 0),
                                new RacingCarPosition("tesla", 0)})
                        , RacingRound.newInstance(new RacingCarPosition[]{
                                new RacingCarPosition("sonata", 1),
                                new RacingCarPosition("sorento", 1),
                                new RacingCarPosition("tesla", 0)})
                        , RacingRound.newInstance(new RacingCarPosition[]{
                                new RacingCarPosition("sonata", 2),
                                new RacingCarPosition("sorento", 2),
                                new RacingCarPosition("tesla", 1)})
                        )),
                        new String[]{"sonata", "sorento"}
                ),
                Arguments.of(new ArrayList<>(Arrays.asList(
                        RacingRound.newInstance(new RacingCarPosition[]{
                                new RacingCarPosition("sonata", 0),
                                new RacingCarPosition("sorento", 0),
                                new RacingCarPosition("tesla", 0)})
                        , RacingRound.newInstance(new RacingCarPosition[]{
                                new RacingCarPosition("sonata", 0),
                                new RacingCarPosition("sorento", 1),
                                new RacingCarPosition("tesla", 0)})
                        )),
                        new String[]{"sorento"}
                ));
    }
}
