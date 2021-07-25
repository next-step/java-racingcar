package step4.view;

import step4.action.Race;

public class ResultView {
    public static void startRaceStep3(int carCounts, int raceTimes) {
        Race race = Race.of(carCounts);
        for(int i=0; i<raceTimes; i++){
            Print.print(race.getCars());
            race.doRace();
            System.out.println();
        }
        Print.print("실행 결과");
        race.doRace();
    }

    public static void startRaceStep4(String[] carNames, int raceTimes) {
        Race race = Race.of(carNames);
        for(int i=0; i<raceTimes; i++){
            Print.print(race.getCars());
            race.doRace();
            System.out.println();
        }
        Print.print("실행 결과");
        race.doRace();
    }
}
