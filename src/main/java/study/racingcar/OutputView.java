package study.racingcar;

public class OutputView {
    /**
     * 출력을 담당한다.
     */
    public void printCarNumberSign() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public void printTryCountSign() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public void printResultSign() {
        System.out.println("실행 결과");
    }

    public void printBlankLine() {
        System.out.println();
    }

    public void printCarStatus(Car car) {
        System.out.println(car.toString());
    }
}