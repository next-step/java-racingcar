package controller;

import java.util.List;
import java.util.Map;

import domain.game.RacingResult;
import view.ResultView;

public class RacingController {

    public void returnGameResults(RacingResult racingResult) {
        List<Map<String, Integer>> result = racingResult.getGameResults();
        for (int i = 0; i < result.size(); i++) {
            printEachResult(result.get(i));
        }
    }

    public void printEachResult(Map<String, Integer> eachRound) {
        for (String name : eachRound.keySet()) {
            ResultView.printEachRound(name, eachRound.get(name));
        }
        ResultView.printSpaceBetweenRounds();
    }

    public void returnWinners(List<String> winnerList) {
        for (int i = 0; i < winnerList.size(); i++) {
            ResultView.printWinnerName(winnerList.get(i));
            if (i < winnerList.size() - 1) {
                ResultView.printComma();
            }
        }
        ResultView.announceWinner();
    }
}
