package game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    /** 게임이 관리하는 자동차 목록 */
    private List<Car> carList = new ArrayList<>();

    /**
     * 자동차가 없는 빈 게임을 생성합니다.
     */
    public Game() {
        this.carList = new ArrayList<>();
    }

    /**
     * 주어진 자동차로 게임을 생성합니다.
     *
     * @param carList 시작 자동차 목록
     */
    public Game(List<Car> carList) {
        this.carList.addAll(carList);
    }

    public String getCarsTrajectories() {
        if (this.carList.size() == 0) {
            return "";
        }

        StringBuilder trajectories = new StringBuilder();

        for (Car car : this.carList) {
            trajectories.append(car.getMoveTrajectory())
                        .append("\n");
        }

        // 마지막에 추가된 \n 제거
        trajectories.deleteCharAt(trajectories.length() - 1);

        return trajectories.toString();
    }

    /**
     * 경기 한 사이클을 진행합니다.
     * 각 자동차들은 자신의 확률에 따라 앞으로 한 칸 갈 수도 있고 안 갈 수도 있습니다.
     */
    public void doACycle() {
        for (Car car : this.carList) {
            car.go();
        }
    }
}
