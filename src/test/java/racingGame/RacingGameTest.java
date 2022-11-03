package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.domain.Car;
import racingGame.domain.Cars;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RacingGameTest {

        @Test
        @DisplayName("레이싱 결과 car2 우승")
        void racingResultTest(){
            Cars cars = new Cars(Arrays.asList(new Car("car1",2)
                                            , new Car("car2",3)));

            List<String> winner = cars.carWinner();
            assertAll(
                    () -> assertThat(winner.contains("car2")).isTrue(),
                    () -> assertThat(winner.contains("car1")).isFalse()
            );
        }

        @Test
        @DisplayName("레이싱 결과 전진 결과가 같을때 무승부")
        void racingAllMoveResultTest(){
            Cars cars = new Cars(Arrays.asList(new Car("car1",3)
                    , new Car("car2",3)));

            List<String> winner = cars.carWinner();

            assertAll(
                    () -> assertThat(winner.contains("car2")).isTrue(),
                    () -> assertThat(winner.contains("car1")).isTrue()
            );
        }

    @Test
    @DisplayName("레이싱 결과 전부 전진 못했을때 무승부")
    void racingFailMoveResultTest(){
        Cars cars = new Cars(Arrays.asList(new Car("car1",0)
                , new Car("car2",0)));

        List<String> winner = cars.carWinner();

        assertAll(
                () -> assertThat(winner.contains("car2")).isTrue(),
                () -> assertThat(winner.contains("car1")).isTrue()
        );
    }
    }

