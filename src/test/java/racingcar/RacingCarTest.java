package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    void inputTest() {

        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int res = InputView.getInput("입력");
        assertThat(3).isEqualTo(res);
    }

    @Test
    void inputExceptionTest() {
        String input = "str";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> InputView.getInput("입력하슝")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("should be number");
    }

    @Test
    @DisplayName("자동차 이동 후 위치가 최대 1만 이동했는지 테스트")
    void carMoveLocationTest() {
        int firstLocation = 2;
        Car car = new Car(firstLocation);

        assertThat(car.move().getLocation()).isBetween(firstLocation, firstLocation + 1);
    }

    @Test
    @DisplayName("Car 컬렉션에서 score를 제대로 뽑아냈는지 테스트")
    void midScoreTest() {

        List<Car> cars = new ArrayList<>(Arrays.asList(new Car(2), new Car(4), new Car(1)));

        MidScore midScore = new MidScore(cars);

        List<Integer> midScoreList = new ArrayList<>(Arrays.asList(2, 4, 1));
        assertThat(midScore.getScores()).isEqualTo(midScoreList);
    }

    @Test
    @DisplayName("게임이 끝나고 시도 횟수 만큼 score가 저장 되었는지 확인")
    void scoreListTest() {

        int numOfCars = 4;
        int numOfTries = 5;

        RacingGame racing = new RacingGame(numOfCars, numOfTries);
        List<MidScore> midScoreList = racing.racingGame();
        assertThat(midScoreList.size()).isEqualTo(numOfTries);
    }

    @Test
    @DisplayName("게임이 끝나고 자동차 수만큼 기록 저장 되었는지 확인")
    void carNumberTest() {

        int numOfCars = 4;
        int numOfTries = 5;

        RacingGame racing = new RacingGame(numOfCars, numOfTries);
        List<MidScore> midScoreList = racing.racingGame();

        midScoreList.forEach(midScore -> assertThat(midScore.getScores().size()).isEqualTo(numOfCars));
    }

}
