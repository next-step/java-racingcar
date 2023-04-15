package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest{

    @Test
    @DisplayName("자동차 대수와 시도횟수 입력받기 ")
    void insertParameter() {

        String input = "3";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes()); // input 문자열을 콘솔입력으로 입력시킨다
        System.setIn(in);

        assertThat(parseInt(input)).isEqualTo(3);
    }

    @Test
    @DisplayName("차 대수 만큼 리스트 만들어서 게임 초기화 ")
    void initGame() {
        RacingGame game = RacingGame.initGame();
        game.playGame();
    }
}
