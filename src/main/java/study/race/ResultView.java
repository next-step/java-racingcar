package study.race;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    public static void resultViewRace(Car[] carNumber) {
        for (int i = 0; i < carNumber.length; i++) {
            String outPut = "-";
            outPut = outPut.repeat(carNumber[i].position);
            System.out.println(carNumber[i].name + " : " + outPut);
        }
    }

    public static void resultViewWinner(int winner, List<String> name) {
        String arr = String.join(",",name);
        String repl = arr.replaceAll("\\[","").replaceAll("\\]","");
        System.out.println(repl+"가 최종우승 했습니다");
    }
}