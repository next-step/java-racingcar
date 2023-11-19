package step5.controller;

import step5.domain.Racing;
import step5.domain.Winners;

public class OutPutView {
    public void winnerIs(Winners winners) {
        System.out.print(winners.toStringWinner());
        System.out.println("가 최종 우승했습니다.");

    }

    public void printHistory(Racing racing) {
        String s = racing.historyToString();
        System.out.println(s);
    }
}
