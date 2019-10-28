package com.seok.racing;

import com.seok.racing.domain.RacingGame;
import com.seok.racing.view.RacingGameInputView;
import com.seok.racing.view.RacingGameOutputView;

public class RacingGameMain {

    public static void main(String[] args) {
      RacingGame game = new RacingGame(RacingGameInputView.getNamesOfCars(), RacingGameInputView.getNumberOfAttempts());
      RacingGameOutputView output = new RacingGameOutputView(game);
      game.start();
      output.printRecords();
      output.printWinner();
    }
}
