package step3;

import helper.TestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.enums.MOVE;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private final int numberOfCars = 5;
    private final int numberOfTurns = 5;

    private RacingGame racingGame;

    @BeforeEach
    void init() {
        this.racingGame = new RacingGame(new RacingGameConfiguration(numberOfCars, numberOfTurns));
    }

    @Test
    @DisplayName("생성자 테스트")
    void gameTest() {
        assertThat(racingGame.getCars().size()).isEqualTo(5);

        racingGame.getCars().forEach(e -> assertThat(e).isExactlyInstanceOf(Car.class));
    }

    @Test
    @DisplayName("go, stop 케이스 모두 발생하는지 테스트")
    void goOrStop() {
        HashSet<MOVE> set = new HashSet<>();

        // 100번의 메소드 호출을 하면 GO, STOP 케이스 모두 나올것으로 가정
        IntStream.range(0, 100)
                .forEach(x -> {
                    try {
                        set.add((MOVE) TestHelper.invokePrivateMethod(racingGame, "goOrStop"));
                    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });

        assertThat(set.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("턴이 진행될때 자동차가 움직이는지 테스트")
    void nextTurnTest() {
        final int testTurns = 100;
        final int sumOfStartLocation = racingGame.getCars().stream().mapToInt(Car::getLocation).sum();

        // 100번의 턴을 진행하면 최소한 하나 이상의 차량은 이동했을것이라고 가정
        IntStream.range(0, testTurns)
                .forEach(x -> {
                    try {
                        TestHelper.invokePrivateMethod(racingGame, "nextTurn");
                    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });

        final int sumOfAfterLocation = racingGame.getCars().stream().mapToInt(Car::getLocation).sum();

        // 차량이 이동했는지 확인
        assertThat(sumOfStartLocation).isNotEqualTo(sumOfAfterLocation);

        // 턴이 진행되었는지 확인
        assertThat(racingGame.getCurrentTurn()).isEqualTo(testTurns);
    }

    @Test
    @DisplayName("게임 진행 테스트")
    void startGameTest() {
        this.racingGame.startGame();

        assertThat(racingGame.getCurrentTurn()).isEqualTo(numberOfTurns);
    }

}
