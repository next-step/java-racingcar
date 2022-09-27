package ThirdStep;

import ThirdStep.model.RecordByRound;
import ThirdStep.services.GameSettingService;
import ThirdStep.services.PlayService;
import ThirdStep.services.RecordService;
import ThirdStep.utils.TextPrintUtils;

import java.util.List;

public class CarRacingGame {
    public static void main(String[] args) {
        GameSettingService gameSettingService = new GameSettingService();
        gameSettingService.setting();

        RecordService recordService = new RecordService();
        PlayService play = new PlayService(recordService);
        List<RecordByRound> record = play.racing(gameSettingService.getGameSetting());

        TextPrintUtils.println("실행 결과");
        recordService.printRecord(record);
        recordService.announceWinner(record);
    }
}
