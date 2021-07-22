package step3.view;

import step3.action.Race;

public class ResultView {
    public static void startRace(int carCounts, int raceTimes) {
        Race race = Race.of(carCounts,raceTimes);
        Print.print("실행 결과");
        race.doRace();
    }
}
