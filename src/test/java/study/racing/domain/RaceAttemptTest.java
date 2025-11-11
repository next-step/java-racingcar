package study.racing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceAttemptTest {

    @Test
    void 객체_정상생성_성공(){
        RaceInput raceInput = new RaceInput("car1,car2,car3", 3, 2);
        RaceAttempt raceAttempt = new RaceAttempt(raceInput);
        assertThat(raceAttempt.getCars().size()).isEqualTo(3);
        assertThat(raceAttempt.getCars().get(0).getName()).isEqualTo("car1");
        assertThat(raceAttempt.getCars().get(1).getName()).isEqualTo("car2");
        assertThat(raceAttempt.getCars().get(2).getName()).isEqualTo("car3");
    }

    @NullAndEmptySource
    @ParameterizedTest
    void 이름이_null_또는_빈값이면_예외발생(String name){
        assertThatThrownBy(() ->  new RaceAttempt(new RaceInput(name, 3, 2)))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 단독_1위_차량_찾기(){
        RaceInput raceInput = new RaceInput("car1,car2,car3,car4,car5", 5, 1);
        RaceAttempt raceAttempt = new RaceAttempt(raceInput);

        raceAttempt.getCars().get(0).forwardPosition();

        List<Car> topCars = raceAttempt.topRankCars();
        assertThat(topCars.get(0).getName()).isEqualTo("car1");
    }

    @Test
    void 공동_1위_차량_모두찾기(){
        RaceInput raceInput = new RaceInput("car1,car2,car3,car4,car5", 5, 1);
        RaceAttempt raceAttempt = new RaceAttempt(raceInput);

        raceAttempt.getCars().get(0).forwardPosition();
        raceAttempt.getCars().get(1).forwardPosition();
        raceAttempt.getCars().get(2).forwardPosition();

        List<Car> topCars = raceAttempt.topRankCars();
        assertThat(topCars).extracting(Car::getName).contains("car3", "car1", "car3");
    }
}