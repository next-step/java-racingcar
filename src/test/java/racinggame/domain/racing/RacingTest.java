package racinggame.domain.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class RacingTest {

    private static Stream<Arguments> provideConstructParam() {
        return Stream.of(
                Arguments.of(1, 1, new ArrayList<String>(Arrays.asList("a"))),
                Arguments.of(2, 2, new ArrayList<String>(Arrays.asList("a", "b"))),
                Arguments.of(3, 3, new ArrayList<String>(Arrays.asList("a", "b", "c"))),
                Arguments.of(4, 4, new ArrayList<String>(Arrays.asList("a", "b", "c", "d")))
        );
    }

    @DisplayName("생성자 테스트")
    @ParameterizedTest
    @MethodSource("provideConstructParam")
    public void construct(int carCount, int gameCount, List<String> carNames) throws Exception {
        //then
        new Racing(carNames, gameCount);
    }

    @DisplayName("레이싱 실행시 라운드수 와 레이싱 진행으로 인해 생긴 result의 크기를 비교")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "3:3", "5:5"}, delimiter = ':')
    public void playAllRound(int gameCount, int expect) throws Exception {
        //given
        List<String> carNames = new ArrayList<>(Arrays.asList("a", "b"));
        Racing racing = new Racing(carNames, gameCount);

        //when
        racing.playAllRound();

        //then
        assertThat(racing.getRacingRoundResults().getResults().size()).isEqualTo(expect);
    }
}
