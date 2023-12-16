package racingcar.ui;

public class UIIntro {
    public void printIntro() {
        clearScreen();
        String introMessage = "RacingCar GAME\n"
                            + "1. 게임 시작\n"
                            + "2. 게임 종료\n";
        System.out.print(introMessage);
    }
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void printException() {
        System.out.println("1번과 2번 중에 고르세요.");
    }
}
