import java.util.List;

public class Judge {
    public String judgeWinner(List<Car> carsList) {
        int maxPosition = 0;
        String winnerName = "";

        for (int i = 0; i < carsList.size(); i++) {
            compareWin(maxPosition, carsList, i);
        }
        for (int i = 0; i < carsList.size(); i++) {
            winnerName += setWinnerList(carsList, i);
        }

        return winnerName;
    }

    private void compareWin(int maxPosition, List<Car> carsList, int i) {
        int compareNum = carsList.get(i).getPosition();

        if (isMax(maxPosition, compareNum).equals(State.BIGGER) || isMax(maxPosition,compareNum).equals(State.SAME)) {
            maxPosition = compareNum;
            carsList.get(i).setWinner(true);
        }
    }

    private String setWinnerList(List<Car> carsList, int i){
        String winnerList = "";
        if (carsList.get(i).getIsWinner() == true) {
            winnerList += carsList.get(i).getCarName() + " ";
        }
        return winnerList;
    }

    private State isMax(int max, int num) {
        if (max < num) {
            return State.BIGGER;
        }
        if (max == num) {
            return State.SAME;
        }
        return State.SMALLER;
    }
}
