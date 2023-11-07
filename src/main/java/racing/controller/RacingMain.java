package racing.controller;


import racing.domain.Racing;
import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.List;

public class RacingMain {

    public static void main(String[] args) {
        // view
        int carCount = InputView.getCarCount();
        int tryCount = InputView.getTryCount();

        Racing racing = new Racing();

        List<List<Integer>> viewList = racing.racingGame(carCount, tryCount);

        for(List<Integer> list : viewList){
            ResultView.viewResultView(list);
        }

    }

}
