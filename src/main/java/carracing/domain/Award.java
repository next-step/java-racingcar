package carracing.domain;

import java.util.*;

import static carracing.utile.SortRanking.sortRanking;

public class Award {
    public static List<String> getWinner(List<Car> cars) {
        //승자이름 추출
        return getWinnerNames(cars);
    }

    private static List<String> getWinnerNames(List<Car> cars) {
        int winnerLocation = getWinnersLocation(cars);
        List<String> winnerCars = new ArrayList<>();
        for (Car car : cars) {
            winnerCars.add(getWinnerName(car, winnerLocation));
        }
        //빈 문자열 리스트 제거
        removeEmptyList(winnerCars);

        return winnerCars;
    }

    private static String getWinnerName(Car car, int winnerLocation) {
        String winnersName = "";
        if (car.isWinner(winnerLocation)) {
            winnersName = car.getName();
        }
        return winnersName;
    }

    private static int getWinnersLocation(List<Car> cars) {
        sortRanking(cars);
        return cars.get(0).getLocation();
    }

    private static void removeEmptyList(List<String> listWinnersName) {
        listWinnersName.removeAll(Arrays.asList(""));
    }
}
