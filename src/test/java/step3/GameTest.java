package step3;

import helper.TestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    private final int numberOfCars = 5;
    private final int numberOfTurns = 5;

    private Game game;

    @BeforeEach
    void init() {
        game = new Game(numberOfCars, numberOfTurns);
    }

    @Test
    @DisplayName("생성자 테스트")
    void gameTest() {
        assertThat(game.getCars().size()).isEqualTo(5);

        game.getCars().forEach(e -> assertThat(e).isExactlyInstanceOf(Car.class));
    }

    @Test
    @DisplayName("go, stop 케이스 모두 발생하는지 테스트")
    void goOrStop() {
        HashSet<MOVE> set = new HashSet<>();

        // 100번의 메소드 호출을 하면 GO, STOP 케이스 모두 나올것으로 가정
        IntStream.range(0, 100)
                .forEach((i) -> {
                    try {
                        set.add((MOVE) TestHelper.invokePrivateMethod(game, "goOrStop"));
                    } catch (NoSuchMethodException |InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });

        assertThat(set.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("턴이 진행될때 자동차가 움직이는지 테스트")
    void nextTurnTest() {
        int sumOfStartLocation = game.getCars().stream().mapToInt(Car::getLocation).sum();

        // 100번의 턴을 진행하면 최소한 하나 이상의 차량은 이동했을것이라고 가정
        IntStream.range(0, 100)
                .forEach((i) -> {
                    try {
                        TestHelper.invokePrivateMethod(game, "nextTurn");
                    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });

        int sumOfAfterLocation = game.getCars().stream().mapToInt(Car::getLocation).sum();

        assertThat(sumOfStartLocation).isNotEqualTo(sumOfAfterLocation);

        assertThat(game.getCurrentTurn()).isEqualTo(100);
    }

    @Test
    @DisplayName("게임 진행 테스트")
    void startGameTest() {
        game.startGame();

        assertThat(game.getCurrentTurn()).isEqualTo(numberOfTurns);
    }

}
