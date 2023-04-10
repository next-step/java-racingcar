package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ResultViewTest {
    private List<Car> racingCars;
    private String RACING_RESULT;
    private List<Car> winningCars;

    @BeforeEach
    void 자동차_리스트_셋팅() {
        // 경기중인 자동차
        racingCars = new ArrayList<>();
        racingCars.add(new Car(1, "car1"));
        racingCars.add(new Car(3, "car3"));
        racingCars.add(new Car(9, "car9"));
        RACING_RESULT = "car1 : -\n" +
                "car3 : ---\n" +
                "car9 : ---------\n";

        // 경기 완주한 자동차
        winningCars = new ArrayList<>();
        winningCars.add(new Car(5, "car1"));
        winningCars.add(new Car(5, "car2"));
        winningCars.add(new Car(5, "car3"));
    }

    @Test
    void 경기_중인_자동차들_출력() {
        String result = ResultView.displayRacingCars(racingCars);
        assertThat(result).contains(RACING_RESULT);
    }


    @Test
    void 자동차들_이름을_출력() {
        String result = ResultView.displayCarsNames(winningCars);

        assertThat(result).contains("car1, car2, car3");
    }

    @Test
    void 빈_자동차들_목록에서_이름을_출력() {
        String result = ResultView.displayCarsNames(new ArrayList<Car>());
        assertThat(result).isEqualTo("");
    }

    @Test
    void 우승한_자동차_출력() {
        assertThat(winningCars).hasSize(3);

        String result = ResultView.displayWinningCars(winningCars);

        assertThat(result).contains("car1, car2, car3가 최중 우승했습니다.");
    }
}
