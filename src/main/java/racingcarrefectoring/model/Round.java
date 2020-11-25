package racingcarrefectoring.model;

import racingcarrefectoring.controller.MainController;

public class Round {

    public static void play(Cars cars){
        for (int i = 0; i < cars.getCount(); i++) {
            Judge.moveOrStop(cars.getCar(i));
        }

        MainController.relayBroadcastRound(cars);
    }
}
