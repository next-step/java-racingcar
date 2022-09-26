package ThirdStep;

import ThirdStep.model.GameSetting;

public class CarRacingGame {
    public static void main(String[] args) {
        GameSetter gameSetter = new GameSetter();
        gameSetter.setting();

        TextPrinter.println("실행 결과");
        Play play = new Play(new CarAction());
        GameSetting gameSetting = gameSetter.getGameSetting();
        play.racing(gameSetting);
        play.announceWinner(gameSetting);
    }
}
