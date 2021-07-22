package racing.util;

import racing.domain.PositionRecord;

public class PositionRecordPrinter {

    public static void print(PositionRecord positionRecord, int index) {
        System.out.println(PositionRecordView.of(positionRecord.getRecordStatus(index)));
    }

}
