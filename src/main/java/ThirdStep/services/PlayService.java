package ThirdStep.services;

import ThirdStep.RandomMovingCondition;
import ThirdStep.model.Car;
import ThirdStep.model.GameSetting;
import ThirdStep.model.RecordByCar;
import ThirdStep.model.RecordByRound;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayService {

    public static final int FIRST_ROUND = 1;
    public RecordService recordService;

    public PlayService(RecordService recordService) {
        this.recordService = recordService;
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
