package racingcar.view;

import java.util.*;
import java.util.stream.Collectors;

public class ResultView {

    private static final char FORWARDING = '-';

    public String printEachCar(int position) {
        String result = "";

        for (int i = 0; i < position; i++) {
            result += FORWARDING;
        }

        return result;
    }

    public void printEachRound(Map<String, Integer> eachRound) {
        Iterator<String> carNames = eachRound.keySet().iterator();

        while(carNames.hasNext()){
            String carName = carNames.next();
            System.out.println(carName + " : " + printEachCar(eachRound.get(carName)));
        }
    }

    public void printResult(Map<Integer, Map<String, Integer>> finalResult, List<String> winners) {
        Iterator<Integer> rounds = finalResult.keySet().iterator();
        int round = 0;

        while(rounds.hasNext()){
            round = rounds.next();
            printEachRound(finalResult.get(round));
            System.out.println();
        }

        String winnerMessage = winners.stream()
                .collect(Collectors.joining(", "));

        System.out.println(winnerMessage + "이(가) 최종 우승했습니다.");
    }
}
