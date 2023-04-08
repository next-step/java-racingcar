package carracing.race.logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class AutomobileFederation {

    private final Map<Integer, List<Integer>> raceResults;
    private final Map<Integer, List<String>> scoreboard;
            //scoreboard

    public AutomobileFederation(Map<Integer, List<Integer>> raceResults) {
        this.raceResults = raceResults;
        this.scoreboard = scoreboardCalculation(raceResults);

    }

    private Map<Integer, List<String>> scoreboardCalculation(Map<Integer, List<Integer>> raceResults) {
        //Map<Integer, List<Integer>> raceResults = federation.getResult();

        ArrayList<Integer> race = new ArrayList<>(raceResults.keySet());
        for (int lap : race) {
            List<Integer> raceResultThisLap = raceResults.get(lap);
            for (int recordCurrentCar : raceResultThisLap) {
                // printStream.print(resultEachCar);
          //      printStream.print(isForward(recordCurrentCar));
            //    printStream.print(" ");

            }
            //printStream.println("");
        }
        //printStream.println();
        return null;
    }

    public Map<Integer, List<Integer>> getResult() {
        return this.raceResults;
    }

    public Map<Integer, List<String>> getScoreboard() {
        return scoreboard;
    }

    public List<Integer> getRounds() {
        ArrayList<Integer> integers = new ArrayList<>(raceResults.keySet());
        integers.sort(Comparator.naturalOrder());
        return integers;
    }

    public List<String> lapSituations(int lap) {
        return null;
    }
}
