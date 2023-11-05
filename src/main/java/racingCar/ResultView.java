package racingCar;

import java.util.Scanner;

public class ResultView {
    public static void noRace() {
        System.out.println("경주 시작 조건이 충족되지 않아 경주가 개최되지 않았습니다.");
    }

    public static void positionPrint(int position) {
        String displayPosition = "";
        for (int i = 0; i < position; i++) {
            displayPosition += "-";
        }
        System.out.println(displayPosition);
    }

    public static void raceStart() {
        System.out.println("....경주 시작!....");
    }

    public static void roundFinish() {
        System.out.println("....라운드 종료!....");
    }
}
