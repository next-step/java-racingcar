package step3.view;

import step3.race.Race;

public class ResultView {



    public static void startRace(int carCounts, int raceTimes) {
        Race race = Race.of(carCounts,raceTimes);

        race.doRace();


    }
}
