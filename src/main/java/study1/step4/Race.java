package study1.step4;

import java.util.ArrayList;

public class Race {
    private final int roundCnt;
    private final Cars cars = new Cars();

    public Race(){
        Tokenizer tokenizer = new Tokenizer();

        String racerListString = InputView.getRacerList();
        tokenizer.TokenListValidate(racerListString);

        cars.initializeCars(tokenizer.getList(racerListString));
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
