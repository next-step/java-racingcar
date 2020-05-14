package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp(){

    }

    @Test
    @DisplayName("차량 대수 지정한 대로 나오는지 테스트")
    void numberOfVehicleTest(){
        RacingGame racingGame = new RacingGame.RacingGameBuilder()
                .setCarNumbers(3)
                .build();

        int carNumbers = racingGame.showEnterCarNumbers();

        assertThat(carNumbers).isEqualTo(3);
    }

    @Test
    @DisplayName("지정한 시도 횟수 나오는지 테스트")
    void numberOfTryTest(){
        RacingGame racingGame = new RacingGame.RacingGameBuilder()
                .setTime(5)
                .build();

        int tryTimes = racingGame.showTryTimes();

        assertThat(tryTimes).isEqualTo(5);
    }

}
