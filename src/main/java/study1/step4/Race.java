package study1.step4;

import java.util.ArrayList;

public class Race {
    private final int roundCnt;
    private final Cars cars;

    public Race(){
        String racerListString = InputView.getRacerList();
        Tokenizer.TokenListValidate(racerListString);
        cars = new Cars(racerListString);
        roundCnt = InputView.getRoundCnt();
    }

    public void race(){
        Decision moveDecisionMaker = new MoveDecision();

        ResultView.startRace(cars);
        for(int i = 0; i < roundCnt; i++){
            cars.race(moveDecisionMaker);
            ResultView.show(cars);
        }

        Award award = new Award();
        ArrayList<String> winnerList = award.getWinnerList(cars);
        ResultView.printWinner(winnerList);
    }
}
