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
        int triedNum = entrys.get(0).getMoveRecord().size();
        for (int i = 0; i < triedNum; i++) {
            for (CarEntry entry : entrys) {
                int score = entry.getMoveRecord().get(i);
                result.append(scoreToPrint(score) + "\n");
            }
            result.append("\n");
        }
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
