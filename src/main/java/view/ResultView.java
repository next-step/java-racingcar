package view;

import domain.CarInfo;

import java.util.List;

public class ResultView {

    public static void printCars(List<CarInfo> car) {
        for (CarInfo element : car) {
            System.out.println(element.getCarName() + " : " + showStatusofCar(element.getCarPosition()));
        }
        System.out.println("\n");
    }
    
    public static String showStatusofCar(int position) {
        StringBuilder status = new StringBuilder();

        for (int i = 0; i < position; ++i) {
            status.append("-");
        }
        return status.toString();
    }

//    public static void disPlayRaceWinner(String winnerNames) {
//        winnerNames = winnerNames.substring(0, winnerNames.length() - 1);
//        System.out.print(winnerNames + "가 최종 우승했습니다.");
//    }
}
