package study.step4;

import java.util.List;

import org.junit.jupiter.api.Test;
import study.step4.domain.*;

import static org.assertj.core.api.Assertions.assertThat;
import static study.step4.view.ResultView.getWinners;

public class RacingTest {

    @Test
    void 자동차의_이름과_상태를_화면에_출력_랜덤값() {
        Racing racing = new Racing(new RandomNumberGenerator());
        List<Car> winners = racing.run(new Rule(getCars(), getMoveTimes()));
        getWinners(winners);
        assertThat(winners).hasSizeBetween(1, getCars().size());
    }

    @Test
    void 자동차의_이름과_상태를_화면에_출력_항상_전진() {
        Racing racing = new Racing(new Always4Generator());
        List<Car> winners = racing.run(new Rule(getCars(), getMoveTimes()));
        assertThat(winners).hasSize(3);
    }

    @Test
    void 자동차의_이름과_상태를_화면에_출력_항상_정지() {
        Racing racing = new Racing(new Always1Generator());
        List<Car> winners = racing.run(new Rule(getCars(), getMoveTimes()));
        assertThat(winners).hasSize(3);
    }

    @Test
    void 우승자_출력() {
        List<Car> cars = List.of(new Car("소나타", 5), new Car("아반떼", 5), new Car("싼타페", 3));
        Racing racing = new Racing(new Always1Generator());
        List<Car> winners = racing.run(new Rule(cars, getMoveTimes()));
        assertThat(getWinners(winners)).hasSize(2);
        assertThat(getWinners(winners)).contains("소나타");
        assertThat(getWinners(winners)).contains("아반떼");
    }

    private static List<Car> getCars() {
        return List.of(new Car("소나타"), new Car("아반떼"), new Car("싼타페"));
    }

    private static int getMoveTimes() {
        return 5;
    }
}
