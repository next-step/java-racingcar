package ThirdStep.controller;

import ThirdStep.domain.model.RecordByRound;
import ThirdStep.domain.GameSettingService;
import ThirdStep.domain.PlayService;
import ThirdStep.view.RecordPrintService;
import ThirdStep.domain.RecordService;

import java.util.List;

public class CarRacingGame {
    public static void main(String[] args) {
        GameSettingService gameSettingService = new GameSettingService();
        gameSettingService.setting();

        PlayService play = new PlayService(new RecordService());
        List<RecordByRound> record = play.racing(gameSettingService.getGameSetting());

        RecordPrintService recordPrintService = new RecordPrintService();
        recordPrintService.printRecord(record);
        recordPrintService.announceWinner(record);
    }
}
