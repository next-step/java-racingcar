package controller;

import model.GameResult;

public interface OutputView {

    String WINNER_MSG = "가 최종 우승했습니다.";

    void printResult(GameResult result);

    void printWinner(GameResult result);
}
