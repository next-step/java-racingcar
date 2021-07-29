package step5;

import helper.TestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private final int NUMBER_OF_TURNS = 100;
    private final List<String> carNames = Stream.of("pobi", "crong", "honux").collect(Collectors.toList());

    private RacingGame racingGame;

    @BeforeEach
    void init() {
        this.racingGame = new RacingGame(new RacingGameConfiguration(carNames, NUMBER_OF_TURNS));
    }

    @Test
    @DisplayName("생성자 테스트")
    void gameTest() {
        assertThat(racingGame.getRacingEntry().getCars().size()).isEqualTo(3);

        racingGame.getRacingEntry().getCars().forEach(e -> assertThat(e).isExactlyInstanceOf(Car.class));
    }

    @Test
    @DisplayName("턴이 진행되었는지 테스트")
    void nextTurnTest() {
        try {
            TestHelper.invokePrivateMethod(racingGame, "nextTurn");
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // 차량이 한칸 이동 (안)했는지 확인
        racingGame.getRacingEntry().getCars()
                .forEach(car -> assertThat(car.getCarLocation().getValue()).isLessThanOrEqualTo(1));

        // 턴이 진행되었는지 확인
        assertThat(racingGame.getCurrentTurn()).isEqualTo(1);
    }

    @Test
    @DisplayName("게임 진행 테스트")
    void startGameTest() {
        this.racingGame.startGame();

        racingGame.getRacingEntry().getCars()
                .forEach(car -> assertThat(car.getCarLocation().getValue()).isLessThanOrEqualTo(NUMBER_OF_TURNS));

        assertThat(racingGame.getCurrentTurn()).isEqualTo(NUMBER_OF_TURNS);
    }

    @Test
    @DisplayName("우승자를 찾는 메소드 테스트")
    void findWinnerCarsTest() {
        this.racingGame.startGame();

        assertThat(this.racingGame.getRacingEntry().findWinnerCars().size()).isGreaterThanOrEqualTo(1);
    }

}
