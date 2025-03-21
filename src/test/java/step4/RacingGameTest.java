package step4;

import org.junit.jupiter.api.Test;
import step3.Car;
import step3.InputView;
import step3.RacingGame;
import step3.ResultView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 질문:
// - 어떤 메소드를 테스트로 작성해야 하는가? 사용자에게 입력을 받는 사소한 메소드도 테스트를 작성하는 게 좋은가?
// - Scanner을 사용한 메소드는 어떻게 테스트를 작성해야 하는가?

class RacingGameTest {

    private RacingGame racingGame;

    @Test
    void testCarNameInputValidation() {
        // 자동차 이름은 한 번에 일괄 입력 받으며, 자동차 이름은 쉼표(,)를 기준으로 구분한다.
        //  e.g. "자동차1", "자동차2", "자동차3"
        // InputView.getCarNames() 구현 시 split(",") 이용

        // 사용자가 입력한 이름의 숫자만큼 자동차 대수를 생성한다.
        // e.g. e.g. "자동차1", "자동차2", "자동차3" -> RacingGame.getCarCount = 3
        //  InputView.getCarCount 기존 로직을 클래스 내 carNames 이용하는 식으로 리팩토링
    }

    @Test
    void testInputViewGetRoundCountFromUser() {
        String mockInput = "5";
        InputView inputView = new InputView(new Scanner(new ByteArrayInputStream(mockInput.getBytes())));
        assertEquals(5, inputView.getRoundCountFromUser());
    }

    @Test
    void testNoMovement() {
        // 랜덤값 4 미만일 시(e.g. 3) Car의 position은 변하지 않아야 함.
        Random mockRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        };
        Car car = new Car(mockRandom);

        int initialPosition = car.getPosition();
        car.move();

        assertEquals(initialPosition, car.getPosition());
    }

    @Test
    void testMoveForward() {
        // 랜덤값 4 이상일 시(e.g. 5) Car의 position은 1씩 증가해야함.
        Random mockRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 5;
            }
        };
        Car car = new Car(mockRandom);

        int initialPosition = car.getPosition();
        car.move();

        assertEquals(initialPosition+1, car.getPosition());
    }


    @Test
    void testResultViewPrintResults() {
        List<List<String>> finalResults = new ArrayList<>();
        List<String> round1 = new ArrayList<>();
        round1.add("---");
        finalResults.add(round1);

        List<String> round2 = new ArrayList<>();
        round2.add("------");
        finalResults.add(round2);

        List<String> round3 = new ArrayList<>();
        round3.add("-----");
        finalResults.add(round3);

        ResultView resultView = new ResultView();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        resultView.printResults(finalResults);

        String expected = "---\n" +"\n"+
                "------\n" +"\n"+
                "-----\n"+"\n";

        assertEquals(expected, outputStream.toString());
    }

    @Test
    void testCarNameOutputValidation() {
        // 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
        //  e.g. "-----" -> "pobi : -----"
        // RacingGame 내 RoundResults.add 부분에 car.getCarName 추가

        // 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
        // e.g. pobi, honux가 최종 우승했습니다.
        // RacingGame.getWinners();
    }
}
