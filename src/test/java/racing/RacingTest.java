package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Scanner;

public class RacingTest {
    InputView inputView;
    Scanner scanner;
    RacingVO racingVO;
    RacingGame racingGame;
    ResultView resultView;


    @BeforeEach
    void setUp() {
        inputView = new InputView();
        scanner = new Scanner(System.in);
        racingVO = new RacingVO(4,10,new int[4]);
        racingGame = new RacingGame(racingVO);
        resultView = new ResultView(racingVO, racingGame);
    }

    @DisplayName("차 대수 및 횟수 0이상 테스트")
    @ParameterizedTest
    @CsvSource({"0"})
    void symbolValidTest(int param) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            inputView.validNumberCheck(param);
        });
    }

    @DisplayName("값이 4이상일 때 움직이는지 테스트")
    @ParameterizedTest
    @ValueSource(
            ints = {4,7,10}
    )
    void movableTest(int param) {
        Assertions.assertThat(racingGame.isMovable(param)).isEqualTo(true);
    }

}