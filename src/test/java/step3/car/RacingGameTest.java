package step3.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingGameTest {

    CarFactory carFactory;

    @BeforeEach
    public void setUp(){
        carFactory = CarFactory.of(4);
//        cars = carFactory.createCars();
    }

    @Test
    @DisplayName("자동차 대수가 0보다 작으면 예외 발생")
    public void moveCountExceptionTest(){

        // given
        int moveCount = -1;

        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> RacingGame.of(moveCount, carFactory)
        );
    }

//    @Test
//    public void gameResultTest(){
//
//        // given
//        int moveCount = 5;
//        RacingGame racingGame = RacingGame.of(moveCount, carFactory);
//
//        // when
//        List<int[]> result = racingGame.start();
//
//        for (int[] arr : result) {
//            System.out.println(Arrays.toString(arr));
//        }
//    }
}