package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AwardTest {
    private final Car sung = new Car("sung",4);
    private final Car jason = new Car("jason",6);
    private final Award award = new Award();
    private final List<Car> cars = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        cars.add(sung);
        cars.add(jason);
    }

    @Test
    @DisplayName("우승자 찾기 테스트")
    public void findWinnerTest() {
        // given
        List<Car> actual = award.findWinner(cars);

        //then
        assertThat(actual).hasSize(1);
    }

    @Test
    @DisplayName("우승자 출력 테스트")
    public void winnerISTest() {
        // given
        List<Car> result = award.findWinner(cars);
        String actual = award.winnerIS(result);

        //then
        assertThat(actual).isEqualTo("jason");
    }
}
