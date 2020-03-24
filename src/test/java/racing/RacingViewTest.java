package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Scanner;

public class RacingViewTest {

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

    @DisplayName("자신의 위치만큼 '-' 출력 테스트 ")
    @ParameterizedTest
    @CsvSource(
            value = {"1:-", "4:----", "5:-----"},
            delimiter = ':'
    )
    void printTest(int param, String result) {
        Assertions.assertThat(resultView.printCar(param)).isEqualTo(result);
    }
}
