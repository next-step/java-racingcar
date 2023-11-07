package racing;

import racing.util.CarGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingGameLogic {
    private RacingGameLogic() {
    }

    /**
     * 레이싱 게임을 새로 시작합니다.
     *
     * @param carList 게임에 참여할 자동차 목록
     * @param theNumberOfCycles 진행할 사이클 수
     *
     * @return 새로 생성된 게임 상태
     */
    public static RacingGameState init(List<Car> carList, int theNumberOfCycles) {
        return RacingGameState.createNewGame(
                carList,
                theNumberOfCycles
        );
    }

    /**
     * 레이싱 게임을 새로 시작합니다.
     *
     * @param theNumberOfCar 생성할 자동차 개수. 자동차 설정은 기본값으로 세팅됩니다.
     * @param theNumberOfCycles 진행할 사이클 수
     *
     * @return 새로 생성된 게임 상태
     */
    public static RacingGameState init(int theNumberOfCar, int theNumberOfCycles) {
        return RacingGameLogic.init(
                CarGenerator.createMultipleDefaultCars(theNumberOfCar),
                theNumberOfCycles
        );
    }

    /**
     * 경기 한 사이클을 진행합니다.
     * 각 자동차들은 자신의 전략에 따라 움직일 것입니다.
     *
     * @param beforeState 이전 게임 상태
     *
     * @return 업데이트 된 게임 상태
     */
    public static RacingGameState update(RacingGameState beforeState) {
        List<Car> carList = beforeState.getCarList();
        int currentCycle = beforeState.getCurrentCycle();

        for (Car car : carList) {
            car.go();
        }

        currentCycle += 1;

        return beforeState.copyWithCarListAndCurrentCycle(carList, currentCycle);
    }

    /**
     * 게임이 끝났는지 판단합니다.
     *
     * @param state 검사할 게임 상태
     *
     * @return 끝났다면 true를 반환.
     */
    public static boolean isGameOver(RacingGameState state) {
        return state.getCurrentCycle() >= state.getTheNumberOfCycles();
    }
}
