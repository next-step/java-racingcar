package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class WinStrategyImpl implements WinStrategy {
    @Override
    public Winners decideWinners(RoundRecords roundRecords) {
        LinkedHashMap<String, Integer> lastRecord = getLastRecord(roundRecords);

        Winners winners = new Winners();
        for (Entry<String, Integer> playerRecord : lastRecord.entrySet()) {
            winners.checkPlayerRecord(playerRecord.getKey(), playerRecord.getValue());
        }

        return winners;
    }

    private LinkedHashMap<String, Integer> getLastRecord(RoundRecords roundRecords) {
        List<RoundRecord> roundRecordList = roundRecords.getRoundRecordList();
        return roundRecordList.get(roundRecordList.size() - 1).getRecord();
    }
}
