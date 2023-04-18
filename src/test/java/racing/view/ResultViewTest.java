package racing.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.FixedRandomForwardStrategy;
import racing.domain.Car;
import racing.domain.Game;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Car car;
    private Game game;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));

        car = new Car("test", new FixedRandomForwardStrategy(5));
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi", new FixedRandomForwardStrategy(5)));
        carList.add(new Car("crong", new FixedRandomForwardStrategy(0)));
        carList.add(new Car("honux", new FixedRandomForwardStrategy(5)));
        game = new Game(carList);
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("자동차 사이클 진행 테스트")
    void printCycle() {
        int cycle = 3;
        for (int i = 0; i < cycle; i++) {
            car.move();
        }
        ResultView.printCarStatus(car.getNameString(), car.getPositionInt());
        assertThat(outContent.toString().trim()).isEqualTo("test : ---");

    }

    @Test
    @DisplayName("자동차 경기 결과 테스트")
    void printResult() {
        int cycle = 3;
        for (int i = 0; i < cycle; i++) {
            game.progressCycle();
        }

        ResultView.printGameStatus(game);
        assertThat(outContent.toString().trim()).isEqualTo("pobi : ---\ncrong : \nhonux : ---");
    }

    @Test
    @DisplayName("자동차 경기 우승자 테스트")
    void printWinner() {
        int cycle = 3;
        for (int i = 0; i < cycle; i++) {
            game.progressCycle();
        }

        ResultView.printWinner(game);
        assertThat(outContent.toString().trim()).isEqualTo("pobi, honux가 최종 우승했습니다.");
    }
}