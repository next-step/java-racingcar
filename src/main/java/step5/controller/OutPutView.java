package step5.controller;

import step5.domain.Racing;
import step5.domain.car.Cars;

public class OutPutView {
    public void winnerIs(Cars winners) {
        System.out.print(winners.toStringWinner());
        System.out.println("가 최종 우승했습니다.");

    }

    public void printHistory(Racing racing) {
        String s = racing.historyToString();
        System.out.println(s);
    }
}
