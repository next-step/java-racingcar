package racingCar.view;

import java.util.List;

public class ResultView {

    public static void printCarStatus(List<String> carStatus){
        System.out.println(String.join("\n", carStatus));
    }

    public static void printWinner(List<String> winners){
        System.out.println(String.join(",", winners));
        System.out.print(winners.get(winners.size()-1) + "가 최종 우승했습니다.");
    }

}
