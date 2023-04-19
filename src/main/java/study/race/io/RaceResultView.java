package study.race.io;

import java.util.List;

import study.race.CarEntry;

public class RaceResultView {

    private char moveSimbol = '-';

    private String initMessage = "실행 결과\n";
    private StringBuilder result;

    public RaceResultView(List<CarEntry> entrys) {
        result = new StringBuilder();
        result.append(initMessage);
        setCarsHistory(entrys);
    }

    private void setCarsHistory(List<CarEntry> entrys) {
        int raceNum = entrys.get(0).getMoveRecord().size();
        for (int raceIndex = 0; raceIndex < raceNum; raceIndex++) {
            String recordByRaceIndex = getEntryRecord(entrys, raceIndex);
            result.append(recordByRaceIndex + "\n");
        }
    }

    private String getEntryRecord(List<CarEntry> entrys, int raceIndex) {
        StringBuilder sb = new StringBuilder();
        for (CarEntry entry : entrys) {
            String entryName = entry.getEntryName();
            int score = entry.getMoveRecord().get(raceIndex);

            sb.append(entryName + " : " + scoreToPrint(score) + "\n");
        }

        return sb.toString();
    }

    private String scoreToPrint(int score) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < score; i++) {
            sb.append(moveSimbol);
        }
        return sb.toString();
    }
    
    public String getPrint() {
        return result.toString();
    }

}
