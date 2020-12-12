package racingcar.domain;

import racingcar.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<String> winners = new ArrayList<>();

    /**
     * 우승자가 누구인지 가져옵니다.
     * @return
     */
    public List<String> getWinner(RacingCars racingCars) {
        int longestDistance = 0;
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            int distance = racingCar.getDistance();
            longestDistance = this.validateLongestDistance(longestDistance, distance);
            this.addLongestDistance(longestDistance, distance, racingCar.getName());
        }
        return this.winners;
    }

    /**
     * 주어진 거리가 가장 긴 거리이면 새로운 우승자 명단을 만들고 가장 긴 거리를 변경합니다.
     * @param longestDistance
     * @param distance
     * @return longestDistance
     */
    private int validateLongestDistance(int longestDistance, int distance) {
        if(distance > longestDistance) {
            this.winners = new ArrayList<>();
            longestDistance = distance;
        }
        return longestDistance;
    }

    /**
     * 주어진 거리가 가장 긴 거리이면 우승자 명단에 이름을 추가합니다.
     * @param longestDistance
     * @param distance
     * @param name
     */
    private void addLongestDistance(int longestDistance, int distance, String name) {
        if(distance >= longestDistance) {
            this.winners.add(name);
        }
    }
}
