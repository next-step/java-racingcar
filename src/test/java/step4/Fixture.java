package step4;

import step4.model.Record;

import java.util.ArrayList;
import java.util.List;

public class Fixture {
    public static List<List<Record>> getAllRecords(List<Record> records) {
        List<List<Record>> allRecords = new ArrayList<>();
        allRecords.add(records);
        return allRecords;
    }
}
