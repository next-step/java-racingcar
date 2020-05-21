package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class CarsJoinRacingTest {

    private static final String DEFAULT_CAR_NAME = "벤츠,제네시스,아우디";
    private static final int[] DEFAULT_WINNER_TARGET_INDEX = {1, 2};

    @DisplayName("입력한 Car Name 이 null 일 때 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    public void createCarListNullEmptyTest(String source) {
        assertThatThrownBy(() -> CarsJoinRacing.newInstance(source))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("레이스 후에 1등을 정상적으로 리턴하는 지 확인")
    @Test
    public void getWinnerTest() {
        CarsJoinRacing racingCar = CarsJoinRacing.newInstance(DEFAULT_CAR_NAME);
        racingCar.race(new RacingTestRule(DEFAULT_WINNER_TARGET_INDEX));

        List<RacingScoreCard> racingScoreCards = racingCar.getWinner();
        List<String> winnerNames = racingScoreCards.stream()
                .map(RacingScoreCard::getName)
                .collect(Collectors.toList());

        assertThat(winnerNames.size()).isEqualTo(2);
        assertThat(winnerNames).contains("제네시스", "아우디");
    }

    @DisplayName("레이스 후에 정상적인 결과가 나오는지 확인")
    @Test
    public void getRaceResultTest() {
        CarsJoinRacing racingCar = CarsJoinRacing.newInstance(DEFAULT_CAR_NAME);
        racingCar.race(new RacingTestRule(DEFAULT_WINNER_TARGET_INDEX));

        List<RacingScoreCard> racingScoreCards = racingCar.getRaceResult();

        List<Integer> positions = racingScoreCards.stream().map(RacingScoreCard::getPosition).collect(Collectors.toList());
        assertThat(positions).containsSequence(0,5,5);
        List<String> name = racingScoreCards.stream().map(RacingScoreCard::getName).collect(Collectors.toList());
        assertThat(name).containsSequence("벤츠","제네시스","아우디");
    }
}