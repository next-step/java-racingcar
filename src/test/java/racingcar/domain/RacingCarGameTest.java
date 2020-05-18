package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("RacingCarGameTest 클래스 테스트")
public class RacingCarGameTest {

    @Test
    @DisplayName("execute 메소드는 레이싱 게임을 실행한다.")
    void execute() {
        // given
        String carName = "테스터";
        int moveCount = 2;
        RacingCarGame racingCarGame = new RacingCarGame(carName, moveCount);

        // when
        racingCarGame.execute(new FixedNumberStrategy());
        List<Car> cars = racingCarGame.getCars();

        // then
        assertAll(
                () -> assertThat(cars).isNotNull(),
                () -> assertThat(cars.size()).isEqualTo(carName.split(",").length),
                () -> assertThat(cars.get(0).getPosition()).isEqualTo(moveCount)
        );

    }

    @Test
    @DisplayName("displayWinner 메소드는 쉼표로 구분된 우승자 이름을 출력한다.")
    void displayWinner() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String carName1 = "테스터1";
        String carName2 = "테스터2";
        List<Car> cars = Arrays.asList(new Car(carName1), new Car(carName2));

        GameResult.displayWinner(cars);

        String expectedOutput = carName1 + "," + carName2 + "가 최종 우승했습니다.\n";

        assertThat(expectedOutput).isEqualTo(outContent.toString());
    }

    private static class FixedNumberStrategy implements Strategy {
        @Override
        public int getNumber() {
            return 5;
        }
    }
}
