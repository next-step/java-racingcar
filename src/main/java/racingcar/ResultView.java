package racingcar;

public class ResultView {
    public static void noRace() {
        resultPrintln("경주 시작 조건이 충족되지 않아 경주가 개최되지 않았습니다.");
    }

    public static void carStatPrint(Car car) {
        StringBuilder carStat = new StringBuilder();
        carStat.append(car.racerName());
        carStat.append(" : ");
        carPosition(carStat, car.currentPosition());
        resultPrintln(carStat.toString());
    }
    public static void carPosition(StringBuilder carStat, int position) {
        for (int i = 0; i < position; i++) {
            carStat.append("-");
        }
    }

    public static void winner(Cars cars) {
        StringBuilder winner = new StringBuilder();
        winner.append(cars.mostFastest());
        winner.append("가 최종 우승했습니다.");
        resultPrintln(winner.toString());
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
