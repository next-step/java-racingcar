package racingcarwinner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RacingPlayTest {

    @DisplayName("input 으로 들어온 carNames 배열로 디폴트 Car 객체 생성")
    @Test
    void 주어진_이름_배열로_Car_리스트_생성() {
        RacingPlay racingPlay = new RacingPlay();
        String[] carNames = new String[]{"test", "tdd", "java"};
        assertThat(racingPlay.readyForRacing(carNames)).hasSize(3);
    }

    @DisplayName("Car 리스트 내에서 max location 을 가진 winner 한 명을 반환한다.")
    @Test
    void Car_리스트_내_winner_1명_반환() {
        RacingPlay racingPlay = new RacingPlay();
        List<Car> carList = Arrays.asList(new Car("a", 2), new Car("b", 3),
                new Car("c", 4));
        assertThat(racingPlay.findWinner(carList)).isEqualTo("c");
    }

    @DisplayName("Car 리스트 내에서 max location 을 가진 winner 여러 명을 반환한다.")
    @Test
    void Car_리스트_내_winner_여러_명_반환() {
        RacingPlay racingPlay = new RacingPlay();
        List<Car> carList = Arrays.asList(new Car("a", 2), new Car("b", 3),
                new Car("c", 4), new Car("d", 4));
        assertThat(racingPlay.findWinner(carList)).isEqualTo("c, d");
    }
}