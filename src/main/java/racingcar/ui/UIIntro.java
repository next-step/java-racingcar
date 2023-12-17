package racingcar.ui;

public class UIIntro {
    public static void printIntro() {
        String introMessage = "RacingCar GAME\n"
                            + "1. 게임 시작\n"
                            + "2. 게임 종료\n";
        System.out.print(introMessage);
    }

    public static void printException() {
        System.out.println("1번과 2번 중에 고르세요.");
    }
}
