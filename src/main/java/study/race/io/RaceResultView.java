package study.race.io;

import java.util.List;

import study.race.CarEntry;
import study.race.CarRace;

public class RaceResultView {

    private char moveSimbol = '-';

    private CarRace carRace;
    private String initMessage = "실행 결과\n";
    private StringBuilder resultPrint = new StringBuilder();

    public RaceResultView(CarRace carRace) {
        this.carRace = carRace;
        this.resultPrint.append(initMessage);
        setCarsHistory(carRace.getRaceResult());
    }

    private void setCarsHistory(List<CarEntry> entrys) {
        int raceNum = entrys.get(0).getMoveRecord().size();
        for (int raceIndex = 0; raceIndex < raceNum; raceIndex++) {
            String recordByRaceIndex = getEntryRecord(entrys, raceIndex);
            resultPrint.append(recordByRaceIndex + "\n");
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
        if (carRace.winner().size() == 0) {
            resultPrint.append("우승자가 없습니다.");
            return resultPrint.toString();
        }

        if (carRace.winner().size() == 1) {
            resultPrint.append(carRace.winner().get(0) + "가 최종 우승했습니다.");
            return resultPrint.toString();
        }

        for (int i = 0; i < carRace.winner().size(); i++) {
            resultPrint.append(carRace.winner().get(i));
            if (i != carRace.winner().size() - 1) {
                resultPrint.append(", ");    
            }
        }
        resultPrint.append("가 최종 우승했습니다.");

        return resultPrint.toString();
    }

}
