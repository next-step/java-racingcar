package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {
    public static String formatLastCharacterRemove(String strings) {
        return strings.replaceAll(Constant.FORMAT_REGULAR_LAST_COMMA, "");
    }

    public List<RacingCar> createRacingCar(String[] carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
        return racingCars;
    }

    public void executeBattle(int tryCnt, List<RacingCar> racingCars) {
        for (int i = 0; i < tryCnt; i++)
            setRandomValue(racingCars);
    }

    public void printWinner(List<RacingCar> racingCars, int winnerPosition) {
        StringBuilder winnerNamesBuilder = new StringBuilder();
        StringBuilder winners = new StringBuilder();
        for (RacingCar car : racingCars) {
            if (car.getCoordinate() == winnerPosition)
                winnerNamesBuilder.append(car.getName()).append(Constant.FORMAT_COMMA);
        }
        String winnerNames = formatLastCharacterRemove(winnerNamesBuilder.toString());
        winners.append(winnerNames);
        winners.append("가 최종 우승했습니다.");
        System.out.println(winners);
    }

    public void setRandomValue(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            int value = racingCar.move(racingCar.createRandom());
            System.out.println(racingCar.getName() + Constant.FORMAT_COLON + getRandomString(value));
        }
        System.out.println("\n");
    }

    public String getRandomString(int coord) {
        StringBuilder coordString = new StringBuilder();
        for (int i = 0; i < coord; i++)
            coordString.append("-");
        return coordString.toString();
    }
}
