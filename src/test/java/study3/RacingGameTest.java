package study3;

import game.InputView;
import game.RacingGame;
import game.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingGameTest {

    @DisplayName("자동차 참여 수 입력 기능 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3"})
    void testGetNumberOfCars(String input) {

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);
        InputView inputView= new InputView(scanner);

        assertEquals(3, inputView.getNumberOfCars());
    }

    @DisplayName("경기 횟수 입력 기능 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"5"})
    void testGetRacingCount(String input) {

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);
        InputView inputView= new InputView(scanner);

        assertEquals(5, inputView.getRacingCount());
    }

    @DisplayName("Random Point  기능 테스트")
    @Test
    void testPoint() {
        RacingGame.create().getPoint();
    }

    @DisplayName("자동차별 이동 횟수 기능 테스트")
    @Test
    void testMove() {
        RacingGame.create().move(3,5);
    }

    @DisplayName("경기 결과 출력 기능 테스트")
    @Test
    void testRacingResultView() {
        int[] testTemp = {3,4,5};
        ResultView.create().racingResultView(testTemp);
    }

    @Test
    void testRacingGameAction() {
        RacingGame.create().racing(3,5);
    }
}
