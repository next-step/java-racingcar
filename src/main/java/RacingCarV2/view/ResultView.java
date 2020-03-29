package RcingCarV2.view;


import RcingCarV2.model.StageResult;

import java.util.List;


public class ResultView {

    public void print(List<StageResult> stageResults) {

        StageView stageView = new StageView(stageResults);
        stageView.print();

        WinnerView winnerView = new WinnerView(stageResults);
        winnerView.print();

    }




}
