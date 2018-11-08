package racingcar;

import org.junit.Before;
import org.junit.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingResultTest {

    private RacingResult racingResult;

    @Before
    public void setup() {
        racingResult = new RacingResult(getDummyCars());
    }

    @Test
    public void 우승자_판별_테스트() {
        String winners = racingResult.getWinners();
        assertThat(winners).isEqualTo("벤츠,마티즈");
    }

    @Test
    public void 우승_포지션값_구하기() {
        int winnerPosition = racingResult.getWinnerPosition();
        assertThat(winnerPosition).isEqualTo(10);
    }

    private List<Car> getDummyCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("붕붕카", 5));
        cars.add(new Car("씽씽카", 2));
        cars.add(new Car("벤츠", 10));
        cars.add(new Car("마티즈", 10));
        return cars;
    }
}