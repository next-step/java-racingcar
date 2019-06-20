package View;

import Domain.CarInfo;

public class ResultView {
    public static void disPlayRacingResult(CarInfo carInfo) {
        String carStatus = "";

        for (int i = 0; i < carInfo.getCarPosition(); ++i)
            carStatus += "-";
        carInfo.setCarStatus(carStatus);
        System.out.println(carInfo.getCarName() + ": " + carInfo.getCarStatus());
    }

    public static void disPlayRaceWinner(String winnerNames) {
        winnerNames = winnerNames.substring(0, winnerNames.length() - 1);
        System.out.print(winnerNames + "가 최종 우승했습니다.");
    }
}
