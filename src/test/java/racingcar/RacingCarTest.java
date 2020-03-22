package racingcar;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Random;

public class RacingCarTest {

    @DisplayName("입력받은 숫자 만큼 -가 출력 되는지 확인.")
    @Test
    void resultViewTest() {
        ResultView.printResultView(5);
    }

    @Test
    void inputViewTest() {
        //Question. Scanner 객체는 어떻게 테스트 할 수 있나요?
    }

    @DisplayName("입력받은 자동차 대수, 이동횟수로 객체 생성 테스트")
    @Test
    void carCreateTest() {
        int carNumber = 3;
        int moveCount = 5;
        RacingGame racingGame = new RacingGame(carNumber, moveCount);
        assertThat(racingGame.startRace().length).isEqualTo(carNumber);
    }

    @DisplayName("자동차 대수, 이동횟수 테스트")
    @Test
    void inputAndCarMakeTest() {
        InputView input = new InputView();
        assertThat(input.carNumber()).isEqualTo(3);
    }

    @DisplayName("요구사항 프로세스를 확인하기 위해 작성한 첫 테스트.")
    @Test
    void processTest() {
        System.out.println("자동차는 몇 대 인가요");
        int cars = 3;
        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = 3;

        //cars의 수 만큼 carPositions  arrays  생성.
        int[] carPositions = new int[cars];

        //랜덤값 생성을 위한 객체
        Random randomNum = new Random();
        //time 만큼 시도.
        String VIEW = "-";
        while (time > 0) {
            for (int i = 0; i < carPositions.length; i++) {
                boolean flag = randomNum.nextInt(10) > -1;
                if (flag) {
                    carPositions[i]++;
                }
                for (int j = 0; j < carPositions[i]; j++) {
                    System.out.printf(VIEW);
                }
                System.out.println();
            }
            time--;
            System.out.println();
        }

    }
}
