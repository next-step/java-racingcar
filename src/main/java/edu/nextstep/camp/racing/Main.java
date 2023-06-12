package edu.nextstep.camp.racing;

import edu.nextstep.camp.racing.domain.RacingInfoFactory;
import edu.nextstep.camp.racing.domain.RacingStarter;

public class Main {
    public static void main(String[] args) {
        RacingStarter racingStarter = new RacingStarter(new RacingInfoFactory());

        racingStarter.start();
    }
}
