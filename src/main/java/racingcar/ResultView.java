package racingcar;

import java.util.Iterator;
import java.util.Map;

public class ResultView {

    public String printEachCar(int position) {
        String result = "";

        for (int i = 0; i < position; i++) {
            result += "-";
        }

        return result;
    }

    public void printEachRound(Map<String, Integer> eachRound) {
        Iterator<String> carNames = eachRound.keySet().iterator();

        while(carNames.hasNext()){
            String carName= carNames.next();
            System.out.println(printEachCar(eachRound.get(carName)));
        }
    }

    public void printResult(Map<Integer, Map<String, Integer>> finalResult) {
        Iterator<Integer> rounds = finalResult.keySet().iterator();

        while(rounds.hasNext()){
            int round = rounds.next();
            printEachRound(finalResult.get(round));
            System.out.println();
        }
    }
}
