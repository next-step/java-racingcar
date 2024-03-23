import java.util.List;

public class Judge {
    public String judgeWinner(List<Car> carsList) {
        int maxPosition = carsList.get(0).getPosition();
        String winner = carsList.get(0).getName();

        for (int i = 1; i < carsList.size(); i++) {
            compareWin(maxPosition, winner, carsList, i);
        }
        return winner;
    }

    private void compareWin(int maxPosition, String winner, List<Car> carsList, int i) {
        int compareNum = carsList.get(i).getPosition();

        if (maxPosition < compareNum) {
            maxPosition = compareNum;
            winner = carsList.get(i).getName();
        }

        if (maxPosition == compareNum) {
            winner = winner + ", " + carsList.get(i).getName();
        }
    }
}
