package racingcar;

import racingcar.rule.RacingRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarDriver {

    private final List<RacingCar> racingCars;
    private List<String> winners = new ArrayList<>();

    public RacingCarDriver(List<RacingCar> racingCars) {
        if (racingCars != null) {
            this.racingCars = racingCars;
            return;
        }
        this.racingCars = new ArrayList<>();
    }

    public static List<RacingCar> createRacingCars(List<String> participants) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String participant : participants) {
            racingCars.add(new RacingCar(participant));
        }
        return racingCars;
    }


    /**
     * 주어진 룰에 맞게 생성된 숫자로 등록된 모든 자동차를 전진시킵니다.
     * @param racingRule
     */
    public void moveForwardAll(RacingRule racingRule) {
        for (RacingCar racingCar : this.racingCars) {
            racingCar.move(racingRule.getNumber());
        }
    }

    /**
     * 자동차의 현재 위치를 받아서 리스트에 담습니다.
     * @return
     */
    public List<Integer> getNowDistance() {
        List<Integer> nowDistances = new ArrayList<>();
        for (RacingCar racingCar : this.racingCars) {
            nowDistances.add(racingCar.getDistance());
        }
        return nowDistances;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }


    /**
     * 우승자가 누구인지 가져옵니다.
     * @return
     */
    public List<String> getWinner() {
        int longestDistance = 0;
        for (RacingCar racingCar : this.getRacingCars()) {
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
