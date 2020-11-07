package racing.domain;

import java.util.*;

import static racing.domain.CarConfig.*;

public class ElectronicControlUnit {

    private final List<StringJoiner> ecu;

    public ElectronicControlUnit() {
        this.ecu = new LinkedList<>();
    }

    public void speedRecord(String nowValue) {
        if(ecu.size() == 0) {
            ecu.add(new StringJoiner(ECU_RECORD_STRING_SEPARATOR).add(nowValue));
            return;
        }
        StringJoiner preRecord = ecu.get(ecu.size() - 1);
        ecu.add(new StringJoiner(ECU_RECORD_STRING_SEPARATOR).merge(preRecord).add(nowValue));
    }

    public String findRecord(int index) {
        return ecu.get(index).toString();
    }

    public List<StringJoiner> get() {
        return ecu;
    }

}
