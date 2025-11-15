package racinggame;

import static racinggame.ui.MC.*;
import static racinggame.ui.MC.askCarNamesToUser;
import static racinggame.ui.ResultView.printCarPositionTitle;
import static racinggame.utils.StringUtils.splitToList;

import java.util.List;
import racinggame.car.Car;
import racinggame.car.Cars;
import racinggame.ui.MC;
import racinggame.ui.UserInput;
import racinggame.utils.StringUtils;

public class RacingGame {
    public static final String CAR_NAME_DELIMITER = ",";
    /**
     * 랜덤값이 4 이상이면 한칸 전진
     * 자동차 상태, 이름 동시 출력 필요
     * 자동차 이름부여
     * 경주후 우승자 출력. 우승자는 여러명 가능.
     * */

    /**
     * 1. 자동차 갯수만큼 생성 행위
     * 2. 자동차들중 포지션 최대값을 찾아내는 행위 -> 이걸위해 생성자 2개 필요 (주/부 생성자)
     * 3. 자동차들중 최대 포지션 값과 동일한 값을 찾아내는 행위
     * 4. 최대한 묻지말고 답하라 원칙과 원시값 문자열 포장방식을 통해 극단적 객체설계 과정으로 진행 + TDD 까지 해보려고 한다. -> 사실 둘중 한가지라도 하려고 하면 두가지 다 잡아갈수 밖에 없는 구조긴 한다.
     * */

    public void start() {
        UserInput userInput = getUserInput();
        List<String> carNameList = splitToList(
                userInput.getCarNames(),
                CAR_NAME_DELIMITER
        );

        startRacing(
                userInput.getTryCount(),
                Cars.createByNames(carNameList)
        );
    }

    private void startRacing(int tryCount, Cars cars) {
        printCarPositionTitle();
        for (int perTry = 0; perTry < tryCount; perTry++) {
        }

    }
}
