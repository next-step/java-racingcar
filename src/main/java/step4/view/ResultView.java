package step4.view;

import step4.action.Race;

public class ResultView {
    public static void startRace(int carCounts, int raceTimes) {
        Race race = Race.of(carCounts);
        for(int i=0; i<raceTimes; i++){
            race.doRace();
            Print.print(race.getPositions().toArray(new Integer[0]));
            System.out.println();
        }
        Print.print("실행 결과");
        race.doRace();
    }
}
