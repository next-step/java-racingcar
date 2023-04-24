package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Race {

    public static List<RacingCar> racingCarList = new ArrayList<>();

    public static void createCars(RacingCarNameRequest names) {

        for (String name : names.getNameList()) {
            RacingCar car = new RacingCar(name);
            racingCarList.add(car);
        }
    }

    public static void race() {
        for (RacingCar racingCar : racingCarList) {
            MovingStrategy movingStrategy = new RandomMovingStrategy();
            racingCar.moveOrStop(movingStrategy);
        }
    }

    public static String[] getEachResult() {
        String[] result = new String[racingCarList.size()];
        for (int i = 0; i < racingCarList.size(); i++) {
            result[i] = racingCarList.get(i).getResult();
        }
        return result;
    }

    public static GameResultResponse playRace(RacingRoundRequest roundRequest) {
        int round = roundRequest.getNumberOfRounds();
        List<String[]> totalResult = new ArrayList<>();
        for (int i = 0; i < round; i++) {
            race();
            totalResult.add(getEachResult());
        }
        return new GameResultResponse(totalResult);
    }

    public static List<String> getWinnerList() {
        List<String> winners = new ArrayList<>();
        int[] matchResult = getDistancesOfRacingCars();
        int maxDistance = getMaxDistance(matchResult);
        for (RacingCar racingCar : racingCarList) {
            addCarToWinnersIfMaxDistance(winners, maxDistance, racingCar);
        }
        return winners;
    }

    private static void addCarToWinnersIfMaxDistance(List<String> winners, int maxDistance, RacingCar racingCar) {
        if (Objects.equals(maxDistance, racingCar.getDistance())) {
            winners.add(racingCar.getName());
        }
    }

    public static int getMaxDistance(int[] matchResult) {

        int maxDistance = matchResult[0];
        for (int distance : matchResult) {
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }
        return maxDistance;
    }

    private static int[] getDistancesOfRacingCars() {
        int[] distances = new int[racingCarList.size()];
        for (int i = 0; i < racingCarList.size(); i++) {
            distances[i] = racingCarList.get(i).getDistance();
        }
        return distances;
    }
}
