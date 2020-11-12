package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarControllerTest {

    CarController controller;

    @Test
    @DisplayName("CarList 초기화 성공 테스트")
    void initCarListTest() {
        String[] carNames = {"name1", "name2", "name3"};
        controller = new CarController(carNames, 1);
        controller.initCarList(carNames);

        assertThat(controller.getCarList().getCarList().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("게임 종료 조건 테스트 - 성공")
    void isFinishSuccessTest() {
        int tryCounts = 5;
        int round = 5;
        controller = new CarController(tryCounts, round);

        assertThat(controller.isFinish()).isTrue();
    }

    @Test
    @DisplayName("게임 종료 조건 테스트 - 실패")
    void isFinishFailTest() {
        int tryCounts = 5;
        int round = 3;
        controller = new CarController(tryCounts, round);

        assertThat(controller.isFinish()).isFalse();
    }

    @Test
    @DisplayName("게임 진행 테스트")
    void nextRoundTest() {
        int tryCounts = 2;
        int round = 1;

        controller = new CarController(tryCounts, round);
        controller.increaseRound();

        assertThat(controller.isFinish()).isTrue();
    }

    @Test
    @DisplayName("우승자 점수 계산 테스트")
    void winnerScoreTest() {
        int winnerScore = 5;
        int looserScore = 3;
        Car car1 = Car.of("a", winnerScore);
        Car car2 = Car.of("b", looserScore);
        CarList carList = CarList.from(Arrays.asList(car1, car2));

        controller = new CarController(carList);

        assertThat(controller.getWinnerScore()).isEqualTo(winnerScore);
    }

    @Test
    @DisplayName("우승자 이름 구하기 테스트 - 1명일 때")
    void winnerOnlyOneNameTest() {
        List<String> winners = new ArrayList<>();
        int winnerScore = 3;
        Car car1 = Car.of("a", winnerScore);
        CarList carList = CarList.from(Arrays.asList(car1));
        controller = new CarController(carList);

        controller.getWinnerName(winnerScore, car1, winners);

        assertThat(winners).containsOnly(car1.getName());
    }

    @Test
    @DisplayName("우승자 이름 구하기 테스트 - 여려명일 때")
    void winnerPeopleNameTest() {
        List<String> winners = new ArrayList<>();
        int winnerScore = 3;
        int looserScore = 2;
        Car car1 = Car.of("a", winnerScore);
        Car car2 = Car.of("b", winnerScore);
        Car car3 = Car.of("c", looserScore);
        CarList carList = CarList.from(Arrays.asList(car1, car2, car3));
        controller = new CarController(carList);

        controller.getWinnerName(winnerScore, car1, winners);
        controller.getWinnerName(winnerScore, car2, winners);
        controller.getWinnerName(winnerScore, car3, winners);

        List<String> compareWinner = Arrays.asList(car1.getName(), car2.getName());

        assertThat(winners).isEqualTo(compareWinner);
    }

    @Test
    @DisplayName("우승자 구하기 테스트 - 1명일 때")
    void winnerOnlyOneTest() {
        int winnerScore = 5;
        String[] carNames = {"name1"};
        controller = new CarController(carNames, winnerScore);

        List<String> winner = controller.getWinners();

        assertThat(winner).containsOnly(carNames);
    }

    @Test
    @DisplayName("우승자 구하기 테스트 - 여러명일 때")
    void winnerPeopleTest() {
        int winnerScore = 5;
        int looserScore = 3;
        Car car1 = Car.of("a", winnerScore);
        Car car2 = Car.of("b", looserScore);
        Car car3 = Car.of("c", winnerScore);
        CarList carList = CarList.from(Arrays.asList(car1, car2, car3));

        controller = new CarController(carList);

        List<String> winner = controller.getWinners();

        List<String> compareWinner = Arrays.asList(car1.getName(), car3.getName());

        assertThat(winner).isEqualTo(compareWinner);
    }
}
