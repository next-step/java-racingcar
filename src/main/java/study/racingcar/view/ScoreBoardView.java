package study.racingcar.view;

import java.util.List;
import java.util.Map;
import study.racingcar.Car;
import study.racingcar.MoveStatus;

public class ScoreBoardView {

    private static final String MOVE_SCORE = "-";
    private static final String STOP_SCORE = "";


    public static String scoreToString(MoveStatus moveStatus){
        if(moveStatus.equals(MoveStatus.MOVE)){
            return MOVE_SCORE;
        }
        return STOP_SCORE;
    }

    public static void printResult(List<Map<Car, String>> listMap) {
        listMap.forEach(map ->{
            map.forEach((car, s) -> {
                System.out.print(car.name() + " : ");
                System.out.println(s);
            });
            System.out.println("\n");
        });
    }

}
