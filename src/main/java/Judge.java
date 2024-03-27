import java.util.List;

public class Judge {
    private int maxPosition = 0;

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

        if (isMax(maxPosition, carsList.get(i).getPosition()) == true) {
            maxPosition = carsList.get(i).getPosition();
        }
    }

    private String setWinnerList(List<Car> carsList, int i) {
        String winnerList = "";

        if (isMax(maxPosition, carsList.get(i).getPosition()) == true) {
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
