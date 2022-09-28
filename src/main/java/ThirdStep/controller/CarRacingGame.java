package ThirdStep.controller;

import ThirdStep.domain.model.RecordByRound;
import ThirdStep.domain.GameSettingService;
import ThirdStep.domain.PlayService;
import ThirdStep.view.RecordPrintService;
import ThirdStep.domain.RecordService;
import ThirdStep.view.utils.TextPrintUtils;

import java.util.List;

public class CarRacingGame {
    public static void main(String[] args) {
        GameSettingService gameSettingService = new GameSettingService();
        gameSettingService.setting();

        RecordService recordService = new RecordService();
        PlayService play = new PlayService(recordService);
        List<RecordByRound> record = play.racing(gameSettingService.getGameSetting());

        TextPrintUtils.println("실행 결과");
        RecordPrintService recordPrintService = new RecordPrintService();
        recordPrintService.printRecord(record);
        recordPrintService.announceWinner(record);
    }
}
