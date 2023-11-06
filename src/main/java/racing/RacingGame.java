package racing;

import java.util.List;

public class RacingGame {
    /** 게임이 관리하는 자동차 목록 */
    private final List<Car> carList;

    /** 진행할 사이클 횟수 **/
    private int theNumberOfCycles;

    /** 진행한 사이클 횟수 */
    public int currentCycle = 0;

    private RacingGame(List<Car> carList, int theNumberOfCycles) {
        this.carList = carList;
        this.theNumberOfCycles = theNumberOfCycles;
    }

    /**
     * 기본값으로 세팅된 새로운 레이싱 게임을 생성합니다.
     *
     * @return 생성된 레이싱 게임
     */
    public static RacingGame createRacingGame() {
        return RacingGame.createRacingGame(3, 5);
    }

    /**
     * 새로운 레이싱 게임을 생성합니다.
     *
     * @param theNumberOfCars 생성할 자동차 개수. 자동차는 모든 것이 기본값으로 세팅되어 생성됩니다.
     * @param theNumberOfCycles 진행할 사이클 수
     *
     * @return 생성된 레이싱 게임
     */
    public static RacingGame createRacingGame(int theNumberOfCars, int theNumberOfCycles) {
        return new RacingGame(
                Car.createDefaultCars(theNumberOfCars),
                theNumberOfCycles
        );
    }

    /**
     * 새로운 레이싱 게임을 생성합니다.
     *
     * @param carList 게임에 참여할 자동차 목록
     * @param theNumberOfCycles 진행할 사이클 수
     *
     * @return 생성된 레이싱 게임
     */
    public static RacingGame createRacingGame(List<Car> carList, int theNumberOfCycles) {
        return new RacingGame(
                carList,
                theNumberOfCycles
        );
    }

    /**
     * 레이싱 게임을 새로 시작합니다.
     *
     * @param theNumberOfCar 생성할 자동차 개수. 자동차 설정은 기본값으로 세팅됩니다.
     * @param theNumberOfCycles 진행할 사이클 수
     */
    public void init(int theNumberOfCar, int theNumberOfCycles) {
        this.carList.clear();
        this.carList.addAll(Car.createDefaultCars(theNumberOfCar));

        this.theNumberOfCycles = theNumberOfCycles;
    }

    /**
     * 경기 한 사이클을 진행합니다.
     * 각 자동차들은 자신의 확률에 따라 앞으로 한 칸 갈 수도 있고 안 갈 수도 있습니다.
     *
     * @return 지정된 사이클에 도달하면 true를 반환하여 게임이 끝났음을 알립니다.
     */
    public boolean update() {
        for (Car car : this.carList) {
            car.go();
        }

        currentCycle += 1;
        return currentCycle >= theNumberOfCycles;
    }

    // 이 이하로 단순 getter
    public List<Car> getCarList() {
        return List.copyOf(this.carList);
    }

}
