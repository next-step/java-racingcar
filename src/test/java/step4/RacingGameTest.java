package step4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step4.domain.Car;
import step4.domain.MoveCondition;
import step4.domain.MoveConditions;
import step4.domain.RacingGame;
import step4.view.InputView;
import step4.view.ResultView;

import java.io.ByteArrayInputStream;
import java.util.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    private RacingGame racingGame;
    private MoveCondition defaultCondition;
    private String defaultCarName;

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        this.defaultCondition = MoveConditions.randomCondition();
        this.defaultCarName = "자동차1";
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testNoMovement() {
        Random mockRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        };
        Car car = new Car(defaultCarName, defaultCondition);

        int initialPosition = car.getPosition();
        car.move();

        assertEquals(initialPosition, car.getPosition(), "랜덤값 4 미만일 시(e.g. 3) Car의 position은 변하지 않아야 합니다.");
    }

    @Test
    void testMoveForward() {
        Random mockRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 4;
            }
        };
        Car car = new Car(defaultCarName, defaultCondition);

        int initialPosition = car.getPosition();
        car.move();

        assertEquals(initialPosition+1, car.getPosition(), "랜덤값 4 이상일 시(e.g. 4) Car의 position은 1씩 증가해야 합니다.");
    }

    @Test
    void testInitialPosition() {
        MoveCondition randomMovement = MoveConditions.randomCondition();
        Car car = new Car(defaultCarName, defaultCondition);

        assertEquals(1, car.getPosition(), "자동차의 초기 위치는 1이어야 합니다.");
    }

    @Test
    void testCarMovementConditionChange () {
        MoveCondition alwaysMove = () -> true;
        Car car = new Car(defaultCarName, alwaysMove);

        int initialPosition = car.getPosition();
        car.move();
        car.move();
        car.move();

        assertEquals(initialPosition + 3, car.getPosition(), "자동차는 항상 이동해야 합니다.");
    }

    /**
     *  [질문]
     *  아래 두 테스트는 InputView 클래스의 입력값 인증 private 메소드 테스트 코드입니다. private 메소드의 테스트 코드를 짜기 위한 방법을 고민하다 각각 다른 두 방식으로 접근하게 되었습니다.
     *
     *  1) testIsCarNameLongerThan5: private 제한자는 그대로 둔 채, InputView 전체를 생성하고 Stream 모킹을 시도
     *
     *  2) testCarNameValidation: public static 제한자로 변경하여, util임을 명시하는 동시에 테스트를 보다 쉽게 만들고자 시도
     *
     *  가능한 모킹을 피하는 것이 좋은 설계라고 들어서 이러한 방법을 시도하게 되었는데, 좋은 접근인지 확신이 서지 않습니다.
     *
     *  적절한 접근인지, 다른 방법은 없었을지, 이에 대한 리뷰어님의 의견을 들을 수 있을까요?
     */
    @Test
    void testIsCarNameLongerThan5() {
        String input = "Short,LongLongName\nCar1,Car2\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);

        List<String> carNames = inputView.getCarNamesFromUser();

        String output = outputStream.toString().trim();
        assert(output.contains("자동차 이름은 5글자까지만 가능해요!"));
    }

    @Test
    void testCarNameValidation() {
        String invalidInput1 = "";
        String invalidInput2 = " ";
        String invalidInput3 = "a;b;c";
        String invalidInput4 = "a,b,c,";
        String invalidInput5 = "a b c ";
        String validInput1 = "a,b,c";

        assertTrue( InputView.isInvalidCarNameFormat(invalidInput1));
        assertTrue( InputView.isInvalidCarNameFormat(invalidInput2));
        assertTrue( InputView.isInvalidCarNameFormat(invalidInput3));
        assertTrue( InputView.isInvalidCarNameFormat(invalidInput4));
        assertTrue( InputView.isInvalidCarNameFormat(invalidInput5));
        assertFalse(InputView.isInvalidCarNameFormat(validInput1));
    }

    @Test
    void testPrintWinnersSingleWinner() {
        Map<String, Integer> lastRound = new HashMap<>();
        lastRound.put("pobi", 5);
        lastRound.put("crong", 3);
        lastRound.put("honux", 4);

        ResultView.printWinners(lastRound);

        String output = outputStream.toString().trim();
        assertTrue(output.contains("pobi가 우승했습니다."));
    }

    @Test
    void testPrintWinnersMultipleWinners() {
        Map<String, Integer> lastRound = new HashMap<>();
        lastRound.put("pobi", 5);
        lastRound.put("crong", 3);
        lastRound.put("honux", 5);

        ResultView.printWinners(lastRound);

        String output = outputStream.toString().trim();
        assertTrue(output.contains("pobi, honux가 우승했습니다."));
    }
}
