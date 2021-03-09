package racingcar.view;

import java.util.*;
import java.util.stream.Collectors;

public class ResultView {

    private static final char FORWARDING = '-';

    public String getWinnerMessage(Map<String, Integer> finalRound, int maxPosition) {
        List<Map.Entry<String, Integer>> finalResults = new ArrayList<>(finalRound.entrySet());

        return finalResults.stream()
                .filter((Map.Entry<String, Integer> result) -> result.getValue() == maxPosition)
                .map(results -> results.getKey())
                .collect(Collectors.joining(", "));
    }

    public void printWinner(Map<String, Integer> finalRound) {
        int maxPosition = Collections.max(finalRound.values());

        String winnerMessage = getWinnerMessage(finalRound, maxPosition) + "이(가) 최종 우승했습니다.";

        System.out.println(winnerMessage);
    }

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

    public void printResult(Map<Integer, Map<String, Integer>> finalResult) {
        Iterator<Integer> rounds = finalResult.keySet().iterator();
        int round = 0;

        while(rounds.hasNext()){
            round = rounds.next();
            printEachRound(finalResult.get(round));
            System.out.println();
        }

        printWinner(finalResult.get(round));
    }
}
