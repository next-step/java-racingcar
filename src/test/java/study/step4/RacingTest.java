package study.step4;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @Test
    void 자동차_경주_랜덤값_테스트() {
        Racing racing = new Racing(new RandomNumberGenerator());
        List<Car> winners = racing.run(new Rule(getCars(), getMoveTimes()));
        assertThat(winners).hasSizeBetween(1, getCars().size());
    }
    
    @Test
    void 자동차_경주_항상_전진_테스트() {
        Racing racing = new Racing(new Always4Generator());
        List<Car> winners = racing.run(new Rule(getCars(), getMoveTimes()));
        assertThat(winners).hasSize(3);
    }

    @Test
    void 자동차_경주_항상_정지_테스트() {
        Racing racing = new Racing(new Always1Generator());
        List<Car> winners = racing.run(new Rule(getCars(), getMoveTimes()));
        assertThat(winners).hasSize(3);
    }

    private static List<Car> getCars() {
        return List.of(new Car("소나타"), new Car("아반떼"), new Car("싼타페"));
    }

    private static int getMoveTimes() {
        return 5;
    }
}
