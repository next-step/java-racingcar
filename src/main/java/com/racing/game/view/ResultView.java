package com.racing.game.view;

import com.racing.game.viewmodel.ResultViewModel;

public class ResultView {

    private final ResultViewModel resultViewModel;

    public ResultView(ResultViewModel resultViewModel) {
        this.resultViewModel = resultViewModel;
    }

    public void drawResultView() {
        System.out.println(resultViewModel.allResultString());
    }
}
