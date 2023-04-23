package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Race {

    public static List<RacingCar> racingCarList = new ArrayList<>();

    public static void createCars(RacingCarNameRequest nameList) {

        for (String name : nameList.getNameList()) {
            isNameValid(name);
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

    private static void isNameValid(String name) {
        if (!RacingCar.isNameValid(name)){
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public static List<String> getWinnerList() {
        List<String> winnerList = new ArrayList<>();
        int[] matchResult = getMatchResult();
        int maxDistance = getMaxDistance(matchResult);
        for (RacingCar racingCar : racingCarList) {
            checkWinner(winnerList, maxDistance, racingCar);
        }
        return winnerList;
    }

    private static void checkWinner(List<String> winnerList, int maxDistance, RacingCar racingCar) {
        if (Objects.equals(maxDistance, racingCar.getDistance())) {
            winnerList.add(racingCar.getName());
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

    private static int[] getMatchResult() {
        int[] matchResult = new int[racingCarList.size()];
        for (int i = 0; i < racingCarList.size(); i++) {
            matchResult[i] = racingCarList.get(i).getDistance();
        }
        return matchResult;
    }
}
