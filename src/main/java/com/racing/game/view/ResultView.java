package com.racing.game.view;

import com.racing.game.viewmodel.ResultViewModel;

public class ResultView {

    private final ResultViewModel resultViewModel;

    public ResultView(ResultViewModel resultViewModel) {
        this.resultViewModel = resultViewModel;
    }

    public void drawResultView() {
        System.out.println("실행결과");
        System.out.println(resultViewModel.allResultString());
    }

    public void drawWinnersView(){
        System.out.println(resultViewModel.winnersName().concat("(이)가 최종 우승했습니다."));
    }
}
