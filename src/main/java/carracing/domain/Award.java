package carracing.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static carracing.view.ResultView.putComma;

public class Award {
    public static String getWinner(List<Car> cars) {
        //경주순위 정렬
        sortRanking(cars);
        //승자목록 추출
        getWinnerList(cars);
        //승자이름 추출
        return getWinnerNames(cars);
    }

    public static void sortRanking(List<Car> cars) {
        Collections.sort(cars, new CompareRank());
    }

    public static List<Car> getWinnerList(List<Car> cars) {
        int winnerLocation = cars.get(0).getLocation();

        Iterator<Car> it = cars.iterator();
        while (it.hasNext()) {
            removeLoser(it, winnerLocation);
        }

        return cars;
    }

    private static void removeLoser(Iterator<Car> it, int winnerLocation) {
        if (it.next().getLocation() != winnerLocation) {
            it.remove();
        }
    }

    private static String getWinnerNames(List<Car> cars) {
        String winnerName = "";
        for (Car car : cars) {
            winnerName = putComma(winnerName);
            winnerName += car.getName();
        }
        return winnerName;
    }

}
