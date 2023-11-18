package step5.controller;

import step5.domain.Racing;
import step5.domain.Referee;
import step5.domain.Winners;
import step5.view.InPutView;

public class Core {
    public static void main(String[] args) {
        // inputview
        String names =  InPutView.name();
        int howManyTry = InPutView.howManyTimesToTrye();

        Referee referee = new Referee();
        Racing racing = Racing.defaultOf(names,referee,howManyTry);

        racing.start();
        Winners winners = racing.winnerIs();


        OutPutView outPutView = new OutPutView();
        outPutView.winnerIs(winners);

    }
}
