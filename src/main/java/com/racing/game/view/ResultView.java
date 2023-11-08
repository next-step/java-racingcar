package com.racing.game.view;

import com.racing.game.viewmodel.ResultViewModel;
import java.util.List;

public class ResultView {

    private static final String CAR_PROGRESS_SYMBOL = "-";

    private final ResultViewModel resultViewModel;

    public ResultView(ResultViewModel resultViewModel) {
        this.resultViewModel = resultViewModel;
    }

    public void drawResultView() {
        for (List<Integer> lap : resultViewModel.raceResult().toResultForm()) {
            printCurrentLapResult(lap);
        }
    }

    private void printCurrentLapResult(List<Integer> lap) {
        for (int progress : lap) {
            printCarProgress(progress);
        }
        System.out.println();
    }

    private void printCarProgress(int progress) {
        for (int i = 0; i < progress; i++) {
            System.out.print(CAR_PROGRESS_SYMBOL);
        }
        System.out.println();
    }
}
