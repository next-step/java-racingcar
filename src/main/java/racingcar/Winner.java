package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Winner {

    RacingCar racingCar = new RacingCar();

    public int createRandomNumber() {
        int number = 0;
        Random random = new Random();
        number = random.nextInt(9);
        return number;
    }

    public void startRacing(int count, String[] carNameArr) {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < carNameArr.length; j++) {
                int number = createRandomNumber();
                carNameArr[j] += racingCar.moveOrNot(number);
                System.out.println(carNameArr[j]);
            }
            System.out.println();
        }
    }

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
