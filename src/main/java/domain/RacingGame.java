package domain;

import domain.type.Position;
import domain.type.RacingGameState;
import util.generator.CarGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    public static final int RANDOM_MAX_BOUND = 10;
    private static Random random = new Random();

    private RacingGame() {
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
        return RacingGame.init(
                CarGenerator.createMultipleDefaultCars(theNumberOfCar),
                theNumberOfCycles
        );
    }

    /**
     * 레이싱 게임을 새로 시작합니다.
     *
     * @param namesOfCar 참여하는 자동차들의 이름 목록. 구분자로 구분하고 이름만큼 자동차가 생성됩니다.
     * @param theNumberOfCycles 진행할 사이클 수
     *
     * @return 새로 생성된 게임 상태
     */
    public static RacingGameState init(String namesOfCar, int theNumberOfCycles) {
        return RacingGame.init(
                CarGenerator.createByMultiNameString(namesOfCar),
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
            car.go(getRandomMoveSeed());
        }

        currentCycle += 1;

        return beforeState.copyWithCarListAndCurrentCycle(carList, currentCycle);
    }

    private static int getRandomMoveSeed() {
        return random.nextInt(RANDOM_MAX_BOUND);
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

    /**
     * 현 게임 상태에서 이기고 있는 자동차의 목록을 반환합니다.
     *
     * @param state 현 게임 상태
     * @return 이기고 있는 자동차들
     */
    public static List<Car> getWinnerList(RacingGameState state) {
        Position maxPosition = Position.origin();

        for (Car car : state.getCarList()) {
            maxPosition = getBiggerPosition(car, maxPosition);
        }

        List<Car> winnerList = new ArrayList<>();
        for (Car car : state.getCarList()) {
            addCarIfItWins(car, maxPosition, winnerList);
        }

        return winnerList;
    }

    private static void addCarIfItWins(Car car, Position maxPosition, List<Car> winnerList) {
        if (car.getPosition().equals(maxPosition)) {
            winnerList.add(car);
        }
    }

    private static Position getBiggerPosition(Car car, Position maxPosition) {
        if (car.getPosition().isBiggerThan(maxPosition)) {
            maxPosition = car.getPosition();
        }
        return maxPosition;
    }
}
