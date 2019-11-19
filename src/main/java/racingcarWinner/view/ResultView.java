package racingcarWinner.view;

import racingcarWinner.domain.Car;

import java.util.List;

public class ResultView {

    private String winner = "";


    public static List<Car> printCurrentCarListPosition(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            printCurrentCarPosition(carList.get(i));
        }
        return carList;
    }

    public static void printCurrentCarPosition(Car car) {
        System.out.println("");
        System.out.print(car.getName() + ":");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

    public void printFinalWinner(List<List<Car>> lapPerCarMovedList, int racingLap) {

        List<Car> carList = lapPerCarMovedList.get(racingLap - 1);
        for (Car car : carList) {
            appendWinner(car);
        }
        System.out.println(winner + "가 최종 우승했습니다.");
    }

    private void appendWinner(Car car) {
        if (car.isFinalWinner()) {
            generateWinnerText(car.getName());
        }
    }

    private void generateWinnerText(String name) {
        if (name.isEmpty()) {
            name = "";
        }
        if (winner != "") {
            winner += ", " + name;
        }

        if (winner.equals("")) {
            winner += name;
        }
    }

    public void printLapPerCarPositionList(List<List<Car>> lapPerCarList) {
        for (List<Car> carList : lapPerCarList) {
            printCurrentCarListPosition(carList);
            System.out.println("  ");
        }
    }

}
