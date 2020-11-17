package study1.step5;

import java.util.ArrayList;

public class Race {
    void race(int roundCnt, String racerListString, Decision decision){
        Cars cars = new Cars(racerListString);

        ResultView.startRace(cars);
        for(int i = 0; i < roundCnt; i++){
            cars.race(decision);
            ResultView.show(cars);
        }

        Award award = new Award();
        ArrayList<String> winnerList = award.getWinnerList(cars);
        study1.step4.ResultView.printWinner(winnerList);
    }
}
