package study.race.view;

import study.race.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultView {
    public static void resultViewRace(List<Car> carNumber) {
        for (int i = 0; i < carNumber.size(); i++) {
            String outPut = "-";
            outPut = outPut.repeat(carNumber.get(i).getPosition());
            System.out.println(carNumber.get(i).getName() + " : " + outPut);
        }
        System.out.println("\n");
    }

    public static void resultViewWinner(List<Car> winners) {

        ArrayList<String> winnersName = new ArrayList<String>();
        for (Car winner : winners) {
            winnersName.add(winner.getName());
        }

        String printWinners = Arrays.toString(new ArrayList[]{winnersName}).replaceAll("\\[","").replaceAll("\\]","");
        System.out.println(printWinners + "가 우승했습니다!ㅊㅊㅊ");
    }
}