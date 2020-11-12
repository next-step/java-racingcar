package step3.domain;

import java.util.List;

public class RaceState implements Displayable {

    private List<CarState> carStates;

    public RaceState(List<CarState> carStates) {
        this.carStates = carStates;
    }

    @Override
    public void displayOn(RaceDisplay raceDisplay) {
        carStates.stream().forEach(it -> {
            StringBuffer sb = new StringBuffer();
            sb.append(it.getName()).append('|');
            int length = it.getMovingDistance();
            while (length-- > 0) { sb.append('-'); }

            raceDisplay.writeLine(sb.toString());
        });
        raceDisplay.writeBlankLine();
    }
}
