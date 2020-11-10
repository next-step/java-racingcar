package race.car;


import java.util.ArrayList;
import java.util.List;

public class WinnerExtract {

    public static List<CarRaceMoveInfo> runExtract(RunCarRace runCarRace) {
        return getCarRaceMaxRank(runCarRace.lastCarRecord(runCarRace));
    }

    private static List<CarRaceMoveInfo> getCarRaceMaxRank(List<CarRaceMoveInfo> lastRaceInfoList) {
        int maxMoveDistance = getMaxMoveDistance(lastRaceInfoList);

        for (int i = lastRaceInfoList.size() - 1; i >= 0; i--) {
            removeIndex(lastRaceInfoList, i, maxMoveDistance);
        }

        return lastRaceInfoList;
    }

    private static void removeIndex(List<CarRaceMoveInfo> lastRaceInfoList, int index, int maxMoveDistance) {
        if (maxMoveDistance != lastRaceInfoList.get(index).getMoveDistance()) {
            lastRaceInfoList.remove(index);
        }
    }

    private static int getMaxMoveDistance(List<CarRaceMoveInfo> lastRaceInfoList) {
        CarRaceMoveInfo returnValue;
        returnValue = lastRaceInfoList.stream()
                .max((first, second) -> Integer.compare(first.getMoveDistance(), second.getMoveDistance())).get();

        return returnValue.getMoveDistance();
    }
}
