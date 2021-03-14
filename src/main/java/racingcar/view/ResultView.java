package racingcar.view;

import racingcar.domain.*;

import java.util.*;
import java.util.stream.Collectors;

public class ResultView {

    private static final char FORWARDING = '-';

    public String printEachCar(Position position) {
        String result = "";

        for (int i = 0; i < position.getPosition(); i++) {
            result += FORWARDING;
        }

        return result;
    }

    public void printEachRound(Map<Name, Position> eachRound) {
        Iterator<Name> carNames = eachRound.keySet()
                                                .iterator();

        while(carNames.hasNext()){
            Name carName = carNames.next();
            System.out.println(carName + " : " + printEachCar(eachRound.get(carName)));
        }
    }

    public void printResult(FinalResult finalResult, List<Car> winners) {
        Iterator<Round> rounds = finalResult.getFinalResult()
                                                .keySet()
                                                .iterator();

        while(rounds.hasNext()){
            Round round = rounds.next();
            printEachRound(finalResult.getFinalResult()
                                        .get(round));
            System.out.println();
        }

        String winnerMessage = winners.stream()
                .map(car -> car.getName()
                                    .toString())
                .collect(Collectors.joining(", "));

        System.out.println(winnerMessage + "이(가) 최종 우승했습니다.");
    }
}
