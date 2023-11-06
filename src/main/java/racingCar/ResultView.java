package racingCar;

public class ResultView {
    public static void noRace() {
        resultPrintln("경주 시작 조건이 충족되지 않아 경주가 개최되지 않았습니다.");
    }

    public static void positionPrint(int position) {
        StringBuilder displayPosition = new StringBuilder();
        for (int i = 0; i < position; i++) {
            displayPosition.append("-");
        }
        resultPrintln(displayPosition.toString());
    }

    public static void racingStart() {
        resultPrintln("....경주 시작!....");
    }

    public static void roundFinish() {
        resultPrintln("....라운드 종료!....");
    }

    private static void resultPrintln(String message) {
        System.out.println(message);
    }
}
