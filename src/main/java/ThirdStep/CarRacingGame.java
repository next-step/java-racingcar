package ThirdStep;

import ThirdStep.model.GameSetting;

public class CarRacingGame {
    public static void run() {
        GameSetter gameSetter = new GameSetter();
        gameSetter.setting();

        TextPrinter.print("실행 결과");
        Play play = new Play(new CarAction());
        GameSetting gameSetting = gameSetter.getGameSetting();
        play.racing(gameSetting);
    }
}
