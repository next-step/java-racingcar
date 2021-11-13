package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private List<RacingCar> racingCars;

    @BeforeEach
    public void setUp() {
        racingCars = Arrays.asList(
                new RacingCar("aaa", 5),
                new RacingCar("bbb", 2),
                new RacingCar("ccc", 5));
    }

    @Test
    @DisplayName("racingCars에서 moveCount가 제일 큰 값을 추출한다.")
    public void maxCountOfMoveCount() {
        int maxCount = racingCars.stream()
                .max(Comparator.comparingInt(RacingCar::getMoveCount))
                .get().getMoveCount();
        assertThat(maxCount).isEqualTo(5);
    }

    @Test
    @DisplayName("moveCount가 maxCount와 같은 RacingCar를 추출한다.")
    public void winnerOfRacingCars() {
        List<RacingCar> winners = racingCars.stream()
                .filter(racingCar -> racingCar.isMoveCountEqualMaxCount(5))
                .collect(Collectors.toList());
        assertThat(winners.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("우승자 이름을 ,로 연결하여 추출한다.")
    public void winnerNameConcat() {
        String winnerNames = racingCars.stream()
                .map(RacingCar::getCarName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames);
    }
}
