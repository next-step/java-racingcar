/*
 * 자동차 경주의 실행(입력)과 출력 및 종료를 담당하는 클래스
 *
 * @author hj-woo
 * @version 2.0
 * */
package step3.racingcar;

import step3.racingcar.domain.Cars;
import step3.racingcar.ui.InputView;
import step3.racingcar.ui.ResultView;
import step4.racingcar.Rule;

import java.util.List;

public class Game {
    public static final String HOW_MANY_CARS = "자동차 대수는 몇 대 인가요?";
    public static final String HOW_MANY_TRYS = "시도할 회수는 몇 회 인가요?";
    public static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private Cars racingCars;
    private int tryNum;

    /*
     * 게임 생성과 동시에 자동차 대수와 시도할 횟수를 확인하고,
     * GameFactory로부터 자동차 대수만큼의 자동차를 넘겨받는다.
     * */
    public Game(String[] strs) {
        List<Object> inputArr = InputView.input(strs);
        for (int i = 0; i < strs.length; i++) {
            checkInputs(inputArr.get(i), strs[i]);
        }
    }

    public void checkInputs(Object input, String str) {
        if (str.equals(HOW_MANY_TRYS)) {
            tryNum = (int) input;
        }
        if (str.equals(HOW_MANY_CARS)) {
            racingCars = GameFactory.cars((Integer) input);
        }
        if (str.equals(INPUT_CAR_NAMES)) {
            String[] names = String.valueOf(input).split(",");
            racingCars = GameFactory.namesCars(names);
        }
    }

    /*
     * 생성한 자동차들과 시도 횟수를 바탕으로 게임을 진행하고 결과를 출력한다.
     * 시도 횟수만큼 다 진행한 후에는 우승자를 출력한다.
     * */
    public void play() {
        System.out.println("실행 결과");
        if (tryNum == 0) {
            System.out.println("아무런 시도를 하지 않았습니다.");
        }
        for (int i = 0; i < tryNum; i++) {
            racingCars.tryForward();
            ResultView.printResultWithName(racingCars.checkCarStatus());
        }
        ResultView.printWinner(Rule.whoIsWinner(racingCars.checkCarStatus()));
    }
}
