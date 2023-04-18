package carracing.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Award {
    public String getWinner(List<Car> cars) {
        //경주순위 정렬
        sortRanking(cars);
        //승자목록 추출
        getWinnerList(cars);
        //승자이름 추출
        return getWinnerNames(cars);
    }

    public void sortRanking(List<Car> cars) {
        Collections.sort(cars, new CompareRank());
    }

    public List<Car> getWinnerList(List<Car> cars) {
        int winnerLocation = cars.get(0).getLocation();

        Iterator<Car> it = cars.iterator();
        while (it.hasNext()) {
            removeLoser(it, winnerLocation);
        }

        return cars;
    }

    private void removeLoser(Iterator<Car> it, int winnerLocation) {
        if (it.next().getLocation() != winnerLocation) {
            it.remove();
        }
    }

    private String getWinnerNames(List<Car> cars) {
        String winnerName = "";
        for (Car car : cars) {
            winnerName = putComma(winnerName);
            winnerName += car.getName();
        }
        return winnerName;
    }

    private String putComma(String winnerName) {
        if (winnerName.isBlank() == false) {
            winnerName += ", ";
        }
        return winnerName;
    }
}
