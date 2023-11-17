package step5.controller;

import step5.domain.Racing;
import step5.domain.Referee;
import step5.domain.Winners;

public class Core {
    public static void main(String[] args) {
        // inputview
        String names = "포비, 구름, 가둥";
        int howManyTry = 4;

        Referee referee = new Referee();
        Racing racing = Racing.defaultOf(names,referee,howManyTry);
        racing.start();
        Winners winners = racing.winnerIs();




    }
}
