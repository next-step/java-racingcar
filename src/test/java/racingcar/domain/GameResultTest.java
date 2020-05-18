package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("GameResult 클래스 테스트")
public class GameResultTest {

    @Test
    @DisplayName("getResult 메소드는 자동차의 위치를 문자로 변환 후 리턴한다.")
    void getResult() {
        // given
        String carName1 = "테스터";
        String carName2 = "테스터2";

        Cars cars = Cars.createCars(carName1.concat(",").concat(carName2));
        cars.carRacing(new FixedNumberStrategy());

        GameResult gameResult = new GameResult(cars);

        // when
        List<String> actual = gameResult.getResult();

        // then
        assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual).hasSize(cars.getSize()),
                () -> assertThat(actual.get(0)).isEqualTo(carName1 + " : -")
        );
    }

    @Test
    @DisplayName("displayWinner 메소드는 쉼표로 구분된 우승자 이름을 출력한다.")
    void displayWinner() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String carNames = "테스터1,테스터2";
        Cars cars = Cars.createCars(carNames);

        GameResult gameResult = new GameResult(cars);
        gameResult.displayWinner(cars);

        String expectedOutput = carNames + "가 최종 우승했습니다.\n";

        assertThat(expectedOutput).isEqualTo(outContent.toString());
    }
}
