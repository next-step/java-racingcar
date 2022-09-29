package ThirdStep.domain;

import ThirdStep.domain.model.GameSetting;
import ThirdStep.domain.model.RecordByCar;
import ThirdStep.domain.model.RecordByRound;

import java.util.ArrayList;
import java.util.List;

public class PlayService {

    public static final int FIRST_ROUND = 1;
    public RecordService recordService;

    public PlayService() {
        this.recordService = new RecordService();
    }

    public List<RecordByRound> racing(GameSetting gameSetting) {
        if (gameSetting.getAttempts() == FIRST_ROUND) {
            List<RecordByCar> initializedRecord = recordService.initRecordByCars(gameSetting.getCars());
            List<RecordByCar> firstRecord = recordService.generateRecordByCar(initializedRecord);
            return List.of(new RecordByRound(firstRecord));
        }

        gameSetting.reduceAttempts();
        List<RecordByRound> allPrevRoundRecord = this.racing(gameSetting);
        List<RecordByCar> currentRecord = recordService.generateRecordByCar(getRecentlyRoundRecord(allPrevRoundRecord));

        List<RecordByRound> newRecord = new ArrayList<>(allPrevRoundRecord);
        newRecord.add(new RecordByRound(currentRecord));

        return newRecord;
    }

    private List<RecordByCar> getRecentlyRoundRecord(List<RecordByRound> allPrevRoundRecord) {
        return allPrevRoundRecord.get(allPrevRoundRecord.size() - 1).getRecordByCars();
    }
}
