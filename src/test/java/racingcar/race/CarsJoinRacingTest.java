package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        List<Car> cars = List.of(
                new Car("벤츠", 1),
                new Car("제네시스", 2),
                new Car("아우디", 4),
                new Car("볼보", 4));
        CarsJoinRacing racingCar = CarsJoinRacing.newInstance(cars);

        List<RacingScoreCard> racingScoreCards = racingCar.getWinner();
        List<String> winnerName = racingScoreCards.stream()
                .map(RacingScoreCard::getName)
                .collect(Collectors.toList());

        assertThat(winnerName.size()).isEqualTo(2);
        assertThat(winnerName).contains("아우디", "볼보");
    }

    @DisplayName("레이스 후에 정상적인 결과가 나오는지 확인")
    @Test
    public void getRaceResultTest() {
        CarsJoinRacing racingCar = CarsJoinRacing.newInstance(DEFAULT_CAR_NAME);
        racingCar.race(new RacingTestRule(DEFAULT_WINNER_TARGET_INDEX));

        List<RacingScoreCard> racingScoreCards = racingCar.getRaceResult();

        List<Integer> positions = racingScoreCards.stream()
                .map(RacingScoreCard::getPosition).collect(Collectors.toList());
        assertThat(positions).containsSequence(0,5,5);
        List<String> name = racingScoreCards.stream()
                .map(RacingScoreCard::getName).collect(Collectors.toList());
        assertThat(name).containsSequence("벤츠","제네시스","아우디");
    }
}