package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차 경주 게임 테스트")
public class CarGameTest {
    int carCnt;
    int tryCnt;
    CarGame game;

    @BeforeEach
    public void beforeEach() {
        carCnt = 3;
        tryCnt = 5;

        game = new CarGame(carCnt, tryCnt);
    }

    @Test
    @DisplayName("자동차수, 시도횟수 입력받아 자동차 수만큼 세팅한다.")
    public void save_cars() {
        assertThat(game.getAllCar()).isEqualTo(carCnt);

        for (int i=0; i< game.getAllCar(); i++) {
            int move = game.getCar(i).getMove();
            int play = game.getCar(i).getPlay();
            assertThat(move).isEqualTo(0);
            assertThat(play).isEqualTo(tryCnt);
        }
    }

    @Test
    @DisplayName("4이상일 경우 자동차가 전진하고, 시도횟수는 한개 줄어야한다.")
    public void car_should_be_moved() {
        //given
        int randomNum = 4;
        int carIdx = 0;

        game.canMove(carIdx, randomNum);

        //then
        int move = game.getCar(carIdx).getMove();
        int play = game.getCar(carIdx).getPlay();
        assertThat(move).isEqualTo(1);
        assertThat(play).isEqualTo(tryCnt-1);

    }

    @Test
    @DisplayName("4미만일 경우 자동차가 움직이지 않고, 시도횟수는 한개 줄어야한다.")
    public void car_should_be_not_moved() {
        //given
        int randomNum = 3;
        int carIdx = 0;

        //when
        game.canMove(carIdx, randomNum);

        //then
        int move = game.getCar(carIdx).getMove();
        int play = game.getCar(carIdx).getPlay();
        assertThat(move).isEqualTo(0);
        assertThat(play).isEqualTo(tryCnt);
    }

    @Test
    public void car_should_be_moved_or_not() {
        //given
        int carIdx = 0;

        int[] randomNums    = {4, 3, 2, 8, 9};
        int[] expectedMove  = {1, 1, 1, 2, 3};
        int[] expectedPlay  = {4, 3, 2, 1, 0};

        for (int i=0; i<randomNums.length; i++) {
            //when
            game.canMove(carIdx, randomNums[i]);

            //then
            int move = game.getCar(carIdx).getMove();
            int play = game.getCar(carIdx).getPlay();
            assertThat(move).isEqualTo(expectedMove[i]);
            assertThat(play).isEqualTo(expectedPlay[i]);
        }

    }


    @Test
    @DisplayName("자동차 움직임만큼 -를 출력한다.")
    public void should_print_cars_move() {
        //given
        int randomNum = 4;
        int carIdx = 0;

        //when
        game.canMove(carIdx, randomNum);

        //then
        String distance = game.printDistance(carIdx);
        assertThat(distance.length()).isEqualTo(1);
    }


}
