package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차 경주 게임 테스트")
public class CarGameTest {
    @Test
    @DisplayName("자동차수, 시도횟수 입력받아 자동차 수만큼 배열에 세팅해야한다.")
    public void save_cars() {
        //given
        int carCnt = 3;
        int tryCnt = 5;

        //when
        CarGame game = new CarGame(carCnt, tryCnt);

        //then
        assertThat(game.getCarsCnt()).isEqualTo(carCnt);
    }
}
