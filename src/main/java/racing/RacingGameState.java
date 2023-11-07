package racing;

import java.util.List;

/** 레이스 게임의 어느 한 시점의 스냅샵입니다.
 *  게임을 구동하기 위한 모든 정보를 기술합니다.
 *  immutable 객체입니다.
 */
public class RacingGameState {
    private final List<Car> carList;
    private final int theNumberOfCycles;
    private final int currentCycle;

    private RacingGameState(List<Car> carList, int theNumberOfCycles, int currentCycle) {
        this.carList = List.copyOf(carList);
        this.theNumberOfCycles = theNumberOfCycles;
        this.currentCycle = currentCycle;
    }

    /**
     * 한 사이클도 진행하지 않은 새 게임 상태를 생성합니다.
     *
     * @param carList 게임에 참여할 자동차 목록
     * @param theNumberOfCycles 목표 사이클
     *
     * @return 생성된 게임 상태
     */
    public static RacingGameState createNewGame(List<Car> carList, int theNumberOfCycles) {
        return new RacingGameState(
                carList,
                theNumberOfCycles,
                0
        );
    }

    /**
     * 매개 변수로 주어진 carList와 currentCycle의 값만 바꾸고 나머지는 기존 값을 유지하는 새로운
     * 상태 객체를 만들어냅니다.
     *
     * @param carList 변경할 자동차 목록
     * @param currentCycle 변경할 현재 사이클 수
     *
     * @return 생성된 게임 상태
     */
    public RacingGameState copyWithCarListAndCurrentCycle(List<Car> carList, int currentCycle) {
        return new RacingGameState(
                carList,
                this.theNumberOfCycles,
                currentCycle
        );
    }

    //이 이하로 단순 getter
    /**
     * @return 게임에 참여중인 자동차의 목록
     */
    public List<Car> getCarList() {
        return List.copyOf(carList);
    }

    /**
     * @return 게임의 목표 사이클 횟수
     */
    public int getTheNumberOfCycles() {
        return theNumberOfCycles;
    }

    /**
     * @return 게임의 현재 진행 사이클 횟수
     */
    public int getCurrentCycle() {
        return currentCycle;
    }

}
