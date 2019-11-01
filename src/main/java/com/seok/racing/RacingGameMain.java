package com.seok.racing;

import com.seok.racing.domain.Racers;
import com.seok.racing.domain.RacingGame;
import com.seok.racing.domain.Trials;
import com.seok.racing.view.RacingGameInputView;
import com.seok.racing.view.RacingGameOutputView;

public class RacingGameMain {

    public static void main(String[] args) {
      Racers racers = RacingGameInputView.getRacers();
      Trials trials = RacingGameInputView.getTrials();
      RacingGameOutputView.print(RacingGame.start(racers,trials));
    }
}
