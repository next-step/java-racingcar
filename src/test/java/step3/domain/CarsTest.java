package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @Test
    @DisplayName("랜덤값에 따라 움직이는가-아예 움직이지 않는다")
    void car_immovable_randomly() {
        // given
        cars.getCars().get(0).forward(2);
        cars.getCars().get(1).forward(3);
        cars.getCars().get(2).forward(5);

        // when
        MoveStrategy moveStrategy = new MoveStrategy() {
            @Override
            public int move() {
                Random random = new Random();
                return ScoreInspector.judgeMovable(random.nextInt(4));
            }
        };
        cars.runRound(moveStrategy);

        // then
        assertThat(cars.getCars().get(0).getStep()).isEqualTo(2);
        assertThat(cars.getCars().get(1).getStep()).isEqualTo(3);
        assertThat(cars.getCars().get(2).getStep()).isEqualTo(5);
    }

    @Test
    @DisplayName("랜덤값에 따라 움직이는가-계속 움직인다")
    void car_movable_randomly() {
        // given
        cars.getCars().get(0).forward(2);
        cars.getCars().get(1).forward(3);
        cars.getCars().get(2).forward(5);

        // when
        MoveStrategy moveStrategy = new MoveStrategy() {
            @Override
            public int move() {
                Random random = new Random();
                return ScoreInspector.judgeMovable(random.nextInt(6)+4);
            }
        };
        cars.runRound(moveStrategy);

        // then
        assertThat(cars.getCars().get(0).getStep()).isEqualTo(3);
        assertThat(cars.getCars().get(1).getStep()).isEqualTo(4);
        assertThat(cars.getCars().get(2).getStep()).isEqualTo(6);
    }

    private void random() {
        Random random = new Random();
        random.nextInt(10);
    }


    @Test
    @DisplayName("현재 라운드까지 진행된 점수판을 가져온다")
    void getRoundScore() {
        // given
        cars.getCars().get(0).forward(2);
        cars.getCars().get(1).forward(1);
        cars.getCars().get(2).forward(3);

        // when
        List<ScoreBoard> scoreBoards = cars.getRoundScore();

        // then
        assertThat(scoreBoards.get(0).getName()).isEqualTo("black");
        assertThat(scoreBoards.get(0).getScoreHistory()).isEqualTo(Arrays.asList(2));

        assertThat(scoreBoards.get(1).getName()).isEqualTo(cars.getCars().get(1).getName());
        assertThat(scoreBoards.get(1).getScoreHistory()).isEqualTo(Arrays.asList(1));

        assertThat(scoreBoards.get(2).getName()).isEqualTo(cars.getCars().get(2).getName());
        assertThat(scoreBoards.get(2).getScoreHistory()).isEqualTo(Arrays.asList(3));
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
