package study.racing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    void 객체_정상생성_성공() {
        RaceInput raceInput = new RaceInput(List.of("car1", "car2", "car3"), 2);
        Cars raceAttempt = new Cars(raceInput.getNames());
        assertThat(raceAttempt.getCars().size()).isEqualTo(3);
        assertThat(raceAttempt.getCars().get(0).getName()).isEqualTo("car1");
        assertThat(raceAttempt.getCars().get(1).getName()).isEqualTo("car2");
        assertThat(raceAttempt.getCars().get(2).getName()).isEqualTo("car3");
    }

    @NullAndEmptySource
    @ParameterizedTest
    void 이름이_null_또는_빈값이면_예외발생(String name) {
        assertThatThrownBy(() -> new Cars(new RaceInput(Arrays.asList(name, name), 2).getNames()))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 단독_1위_차량_찾기() {
        RaceInput raceInput = new RaceInput(List.of("car1", "car2", "car3", "car4", "car5"), 5);
        Cars raceAttempt = new Cars(raceInput.getNames());

        raceAttempt.getCars().get(0).move();

        List<Car> topCars = raceAttempt.topRankCars();
        assertThat(topCars.get(0).getName()).isEqualTo("car1");
    }

    @Test
    void 공동_1위_차량_모두찾기() {
        RaceInput raceInput = new RaceInput(List.of("car1", "car2", "car3", "car4", "car5"), 1);
        Cars raceAttempt = new Cars(raceInput.getNames());

        raceAttempt.getCars().get(0).move();
        raceAttempt.getCars().get(1).move();
        raceAttempt.getCars().get(2).move();

        List<Car> topCars = raceAttempt.topRankCars();
        assertThat(topCars).extracting(Car::getName).contains("car3", "car1", "car3");
    }
}