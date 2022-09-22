package ThirdStep;

public class CarRacingGame {
    public static void run() {
        GameSetting newGameSetting = new GameSetting();
        newGameSetting.setting();

        TextPrinter.print("실행 결과");
        Play.racing(newGameSetting.getCars(), newGameSetting.getAttempts());
    }




}
