package step3.view;

import step3.action.Race;

public class ResultView {
    public static void startRace(int carCounts, int raceTimes) {
        Race race = Race.of(carCounts);
        Print.print("실행 결과");
        for(int i=0; i<raceTimes; i++){
            race.doRace();
            Print.print(race.getPositions().toArray(new Integer[0]));
            System.out.println();
        }
    }
}
