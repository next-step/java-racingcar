package racingcar.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Records {

    public static final Records EMPTY_RECORDS = new Records();

    private final Map<Lap, Record> values;

    private Records() {
        this.values = Collections.unmodifiableMap(new HashMap<>());
    }

    private Records(Map<Lap, Record> values) {
        this.values = values;
    }

    public Records record(Lap lap, Record record) {
        Map<Lap, Record> temp = new HashMap<>(values);
        temp.put(lap, record);
        return new Records(Collections.unmodifiableMap(temp));
    }

    public Map<Lap, Record> getValues() {
        return values;
    }
}
