package racing.domain;

import racing.Car;

public class GetWinner {

    public static String getWinner(int maxPosition, Car[] cars) {
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
