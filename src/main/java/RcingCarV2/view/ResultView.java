package RcingCarV2;


import RcingCarV2.model.StageResult;

import java.util.List;


public class ResultView {

    void print(List<StageResult> stageResults) {

        StageView stageView = new StageView(stageResults);
        stageView.print();

        WinnerView winnerView = new WinnerView(stageResults);
        winnerView.print();

    }




}
