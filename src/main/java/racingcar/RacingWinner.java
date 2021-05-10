package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingWinner {

    public List<String> selectWinner(String[] carNameArr) {
        List<String> winnerList = new ArrayList<String>();
        int maxlenth = 0;
        for (int i = 0; i < carNameArr.length; i++) {
            if (carNameArr[i].substring(carNameArr[i].indexOf(":") + 2, carNameArr[i].length()).length() >
                    maxlenth) {
                maxlenth = carNameArr[i].substring(carNameArr[i].indexOf(":") + 2, carNameArr[i].length()).length();
            }
        }
        for (int i = 0; i < carNameArr.length; i++) {
            if (maxlenth == carNameArr[i].substring(carNameArr[i].indexOf(":") + 2, carNameArr[i].length()).length()) {
                winnerList.add(carNameArr[i]);
            }
        }
        return winnerList;
    }

    public String removeRegex(List<String> winnerList) {
        String winner = winnerList.toString()
                .replaceAll("\\]", "")
                .replaceAll("\\[", "")
                .replaceAll(":", "")
                .replaceAll("-", "")
                .replaceAll("  ,", ",");
        return winner;
    }

}
