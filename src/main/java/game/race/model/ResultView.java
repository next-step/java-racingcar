package game.race.model;

import java.util.ArrayList;
import java.util.List;

import game.race.Race;

public class ResultView {

    private static final String END_MARK = "";

    private final List<String> tireMarks = new ArrayList<>();

    public List<String> getTireMarks() {
        return tireMarks;
    }

    public void setResult(Race race) {
        int vehicleCnt = race.getVehicleCnt();
        for (String tireMark : race.getTireMarks()) {
            tireMarks.add(tireMark);

            vehicleCnt--;
            if (vehicleCnt == 0) {
                tireMarks.add(END_MARK);
                vehicleCnt = race.getVehicleCnt();
            }
        }
    }
}
