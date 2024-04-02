import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();
    private int maxPositionStorage = 0;

    public List<Car> makeCars(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            cars.add(new Car(strArr[i],0));
        }
        return cars;
    }
    public String judgeWinner(List<Car> carsList) {
        StringBuilder winnerName = new StringBuilder();

        for (int i = 0; i < carsList.size(); i++) {
            findMax(carsList, i);
        }

        for (int i = 0; i < carsList.size(); i++) {
            winnerName.append(setWinnerList(carsList, i));
        }

        return winnerName.toString();
    }

    private void findMax(List<Car> carsList, int i) {

        if (isMax(maxPositionStorage, carsList.get(i).getPosition()) == true) {
            maxPositionStorage = carsList.get(i).getPosition();
        }
    }


    private String setWinnerList(List<Car> carsList, int i) {
        String winnerList = "";

        if (isMax(maxPositionStorage, carsList.get(i).getPosition()) == true) {
            winnerList += carsList.get(i).getCarName() + " ";
        }

        return winnerList;
    }

    private boolean isMax(int max, int num) {
        if (max < num) {
            return true;
        }
        if (max == num) {
            return true;
        }
        return false;
    }

}