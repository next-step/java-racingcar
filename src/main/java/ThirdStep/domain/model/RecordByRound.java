package ThirdStep.domain.model;

import java.util.ArrayList;
import java.util.List;

public class RecordByRound {
    private final List<RecordByCar> recordByCars = new ArrayList<>();

    public List<RecordByCar> getRecordByCars() {
        return recordByCars;
    }

    public RecordByRound(List<RecordByCar> recordByCar) {
        this.recordByCars.addAll(recordByCar);
    }
}
