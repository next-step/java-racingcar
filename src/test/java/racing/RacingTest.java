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

    public RacingTest() {
    }

    @BeforeEach
    void setUp() {
        this.inputView = new InputView();
        this.scanner = new Scanner(System.in);
        RacingVO var10001 = this.racingVO;
        this.racingVO = RacingVO.getInstance();
        this.racingGame = new RacingGame(this.racingVO);
        this.resultView = new ResultView(this.racingVO, this.racingGame);
    }

    @DisplayName("차 대수 및 횟수 0이상 테스트")
    @ParameterizedTest
    @CsvSource({"0"})
    void symbolValidTest(int param) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            this.inputView.validNumberCheck(param);
        });
    }

    @DisplayName("값이 4이상일 때 움직이는지 테스트")
    @ParameterizedTest
    @ValueSource(
            ints = {1, 2, 3, 4, 5, 6}
    )
    void movableTest(int param) {
        Assertions.assertThat(this.racingGame.isMovable(param)).isEqualTo(true);
    }

    @DisplayName("자신의 위치만큼 '-' 출력 테스트 ")
    @ParameterizedTest
    @CsvSource(
            value = {"1:-", "2:---", "3:---"},
            delimiter = ':'
    )
    void printTest(int param, String result) {
        Assertions.assertThat(this.resultView.printCar(param)).isEqualTo(result);
    }
}