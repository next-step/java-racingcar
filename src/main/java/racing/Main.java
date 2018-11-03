package racing;

import racing.domain.RacingGame;
import racing.ui.ConsoleUI;
import racing.dto.RacingGameCreateRequest;

import java.util.List;

/**
 * 초간단 자동차 경주 게임을 구현한다.
 * <p>
 * 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 * 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 * 전진하는 조건은 0에서 9사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
 * 자동차의 상태를 화면에 출력한다.어느 시점에 출력할 것인지에 대한 제약은 없다.
 */
public class Main {

    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
        RacingGameCreateRequest request = consoleUI.getRacingGameCreateInput();

        // 레이싱게임 클래스를 생성합니다.
        RacingGame racingGame = new RacingGame(request.getCarNumber(), request.getTime());

        consoleUI.printResultHeader();
        // 횟수가 끝날때까지 작업을 수행합니다
        while (racingGame.isRacingAvailable()) {
            List<Integer> positions = racingGame.race();
            consoleUI.printRacingCarPositions(positions);
        }
    }
}
