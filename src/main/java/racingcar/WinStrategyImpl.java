package racingcar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class WinStrategyImpl implements WinStrategy {
    @Override
    public Winners decideWinners(RoundRecords roundRecords) {
        List<RoundRecord> roundRecordList = roundRecords.getRoundRecordList();
        LinkedHashMap<String, Integer> lastRecord = roundRecordList.get(roundRecordList.size() - 1).getRecord();

        Winners winners = new Winners();
        for (Entry<String, Integer> playerRecord : lastRecord.entrySet()) {
            winners.checkNewPlayerRecord(playerRecord.getKey(), playerRecord.getValue());
        }

        return winners;
    }
}
