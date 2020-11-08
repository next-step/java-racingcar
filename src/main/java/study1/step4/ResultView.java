package study1.step4;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ResultView {
    public static void startRace(List<Car> cars){
        System.out.println("실행 결과");
        show(cars);
    }

    public static void show(List<Car> cars){
        for(Car car: cars){
            System.out.println(car.getMoveResult());
        }
        System.out.println("");
    }

    public static void printWinner(ArrayList<String> winnerList){
        StringJoiner winnerText = new StringJoiner(", ");
        for(String winner: winnerList){
            winnerText.add(winner);
        }
        System.out.println(winnerText.toString() + "가 최종우승했습니다.");
    }
}
