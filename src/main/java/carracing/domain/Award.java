package carracing.domain;

import java.util.*;

import static carracing.view.ResultView.putComma;
import static carracing.view.ResultView.removeEmptyList;

public class Award {
    public static String getWinner(List<Car> cars) {
        //경주순위 정렬
        sortRanking(cars);
        //승자이름 추출
        return getWinnerNames(cars);
    }

    public static void sortRanking(List<Car> cars) {
        Collections.sort(cars, new CompareRank());
    }

    public static String getWinnerNames(List<Car> cars) {
        int winnerLocation = cars.get(0).getLocation();
        List<String> listWinnersName = new ArrayList<>();
        for (Car car : cars) {
            listWinnersName.add(getWinnerName(car, winnerLocation));
        }
        //빈 문자열 리스트 제거
        removeEmptyList(listWinnersName);

        return putComma(listWinnersName);
    }

    public static String getWinnerName(Car car, int winnerLocation) {
        String winnersName = "";
        if (car.isWinner(winnerLocation)) {
            winnersName = car.getName();
        }
        return winnersName;
    }

}
