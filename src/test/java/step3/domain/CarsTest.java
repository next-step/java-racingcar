package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Cars;
import step3.domain.ScoreBoard;
import step3.domain.strategy.Movable;
import step3.domain.strategy.MoveStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created By mand2 on 2020-11-10.
 */
class CarsTest {

    Cars cars;

    @BeforeEach
    void setUp() {
        cars = Cars.of("black,no,peace");
    }

    @ParameterizedTest
    @DisplayName("랜덤값에 따라 움직이는가-아예 움직이지 않는다")
    @ValueSource(ints = {2,3,5})
    void car_immovable_randomly(int input) {
        // given
        for (Car car : cars.getCars()) {
            car.forward(input);
        }

        // when
        MoveStrategy moveStrategy = new MoveStrategy(new Randomize()) {
            @Override
            public int move() {
                Random random = new Random();
                return ScoreInspector.judgeMovable(random.nextInt(4));
            }
        };
        cars.runRound(moveStrategy);

        // then
        for (Car car : cars.getCars()) {
            assertThat(car.getStep()).isEqualTo(input);
        }
    }

    @ParameterizedTest
    @DisplayName("랜덤값에 따라 움직이는가-계속 움직인다")
    @ValueSource(ints = {2,3,5})
    void car_movable_randomly(int input) {
        // given
        for (Car car : cars.getCars()) {
            car.forward(input);
        }

        // when
        MoveStrategy moveStrategy = new MoveStrategy(new Randomize()) {
            @Override
            public int move() {
                Random random = new Random();
                return ScoreInspector.judgeMovable(random.nextInt(6)+4);
            }
        };
        cars.runRound(moveStrategy);

        // then
        for (Car car : cars.getCars()) {
            assertThat(car.getStep()).isEqualTo(input + 1);
        }
    }

    @ParameterizedTest
    @DisplayName("현재 라운드까지 진행된 점수판을 가져온다")
    @ValueSource(ints = {2, 1, 3})
    void getRoundScore(int step) {
        // given
        for (Car car : cars.getCars()) {
            car.forward(step);
        }

        // when
        List<ScoreBoard> scoreBoards = cars.getRoundScore();

        // then
        for (ScoreBoard scoreBoard : scoreBoards) {
            assertThat(scoreBoard.getScoreHistory()).containsOnly(step);
        }
    }

    @Test
    @DisplayName("다른 경기장에 배정된, 차이름도 같은 경주차그룹은 점수가 같아도 " +
            "실제로 같은 그룹을 나타내지 않는다")
    void cars_in_another_racingPlace_actually_different() {
        // given
        cars.getCars().get(0).forward(2);
        cars.getCars().get(1).forward(1);
        cars.getCars().get(2).forward(3);


        // when
        Cars another = Cars.of("black,no,peace");
        another.getCars().get(0).forward(2);
        another.getCars().get(1).forward(1);
        another.getCars().get(2).forward(3);

        // then
        assertEquals(cars.equals(another), false);
    }
}
