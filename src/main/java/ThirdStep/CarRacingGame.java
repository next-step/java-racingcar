package ThirdStep;

import ThirdStep.model.GameSetting;
import ThirdStep.services.CarService;
import ThirdStep.services.GameSettingService;
import ThirdStep.services.PlayService;
import ThirdStep.utils.TextPrintUtils;

public class CarRacingGame {
    public static void main(String[] args) {
        GameSettingService gameSettingService = new GameSettingService();
        gameSettingService.setting();

        TextPrintUtils.println("실행 결과");
        PlayService play = new PlayService(new CarService());
        GameSetting gameSetting = gameSettingService.getGameSetting();
        play.racing(gameSetting);
        play.announceWinner(gameSetting);
    }
}
