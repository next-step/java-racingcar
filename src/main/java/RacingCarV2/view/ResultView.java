package RacingCarV2.view;


import RacingCarV2.model.StageResult;

import java.util.List;


public class ResultView {

    public void print(List<StageResult> stageResults) {

        StageView stageView = new StageView(stageResults);
        stageView.print();

        WinnerView winnerView = new WinnerView(stageResults);
        winnerView.print();

    }




}
