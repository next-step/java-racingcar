package com.nextstep.javaRacing.racing;

import com.nextstep.javaRacing.racing.race.Race;
import com.nextstep.javaRacing.racing.race.RaceFactory;
import com.nextstep.javaRacing.racing.view.InputView;

public class RacingApplication {

    public static void main(String[] args) {
        Race race = RaceFactory.prepareRace(InputView.scanCarNames(), InputView.scanTurns());
        race.race();
    }
}
