package study.step4;

import java.util.List;

import org.junit.jupiter.api.Test;
import study.step4.domain.*;

import static org.assertj.core.api.Assertions.assertThat;
import static study.step4.view.ResultView.showResult;

public class RacingTest {

    @Test
    void 자동차의_이름과_상태를_화면에_출력_랜덤값() {
        Racing racing = new Racing(new RandomNumberGenerator());
        Cars cars = racing.run(new Rule(getCars(), getMoveTimes()));
        assertThat(cars.getCars()).hasSizeBetween(1, getCars().size());
    }

    @Test
    void 자동차의_이름과_상태를_화면에_출력_항상_전진() {
        Racing racing = new Racing(new Always4Generator());
        Cars cars = racing.run(new Rule(getCars(), getMoveTimes()));
        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    void 자동차의_이름과_상태를_화면에_출력_항상_정지() {
        Racing racing = new Racing(new Always1Generator());
        Cars cars = racing.run(new Rule(getCars(), getMoveTimes()));
        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    void 우승자_출력() {
        Car sonata = new Car("소나타", 5);
        Car avante = new Car("아반떼", 5);
        Car santafe = new Car("싼타페", 3);
        List<Car> cars = List.of(sonata, avante, santafe);

        Racing racing = new Racing(new Always1Generator());
        Cars winners = racing.run(new Rule(cars, getMoveTimes()));
        showResult(winners);
        assertThat(winners.getCars()).hasSize(2);
        assertThat(winners.getCars()).contains(sonata);
        assertThat(winners.getCars()).contains(avante);
    }

    private static List<Car> getCars() {
        return List.of(
            new Car("소나타"),
            new Car("아반떼"),
            new Car("싼타페")
        );
    }

    private static int getMoveTimes() {
        return 5;
    }
}
