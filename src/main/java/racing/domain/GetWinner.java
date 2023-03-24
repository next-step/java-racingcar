package racing.domain;

import static racing.TheGame.cars;

public class GetWinner {

    public static String getWinner(int maxPosition) {
        String winnerName = "";
        int winnerCnt = 0;

        for (int i = 0; i < cars.length; i++) {

            if (cars[i].getPosition() == maxPosition) {
                winnerCnt++;
                if (winnerCnt >= 2) {
                    winnerName += ", ";
                }
                winnerName += cars[i].getName();
            }
        }

        return winnerName;
    }
}
