package racing.domain;

import java.util.*;

import static racing.domain.CarConfig.*;

public class CarSetInRace {


    private final List<StringJoiner> setRace;

    public CarSetInRace() {
        this.setRace = new LinkedList<>();
    }

    public void stop() {
        if(setRace.isEmpty()) {
            setRace.add(new StringJoiner(CAR_RECORD_STRING_SEPARATOR).add(CAR_STOP_MOVE_CODE));
            return;
        }
        StringJoiner preRecord = setRace.get(setRace.size() - 1);
        setRace.add(new StringJoiner(CAR_RECORD_STRING_SEPARATOR).merge(preRecord).add(CAR_STOP_MOVE_CODE));
    }

    public void move() {
        if(setRace.isEmpty()) {
            setRace.add(new StringJoiner(CAR_RECORD_STRING_SEPARATOR).add(CAR_NORMAL_MOVE_CODE));
            return;
        }
        StringJoiner preRecord = setRace.get(setRace.size() - 1);
        setRace.add(new StringJoiner(CAR_RECORD_STRING_SEPARATOR).merge(preRecord).add(CAR_NORMAL_MOVE_CODE));
    }

    public String findRecord(int index) {
        return setRace.get(index).toString();
    }

    public List<StringJoiner> getRecord() {
        return setRace;
    }

    public int getMoveSize() {
        return findRecord(setRace.size() - 1)
                .replaceAll(CAR_RECORD_STRING_SEPARATOR,"")
                .replaceAll(CAR_STOP_MOVE_CODE,"")
                .length();
    }

}
