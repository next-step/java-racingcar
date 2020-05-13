package com.nextstep.racingcar.ui;

import java.util.List;

public class OutputView {
    private List<String> results;

    public OutputView(List<String> results) {
        this.results = results;
    }

    public void printResults() {
        System.out.println("\n실행 결과");
        for (String result : this.results) {
            System.out.println(result);
        }
    }
}
