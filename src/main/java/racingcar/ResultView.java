package racingcar;

public class ResultView {
    public void questionCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public void questionTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

    public void executeResult() {
        System.out.println("실행 결과");
    }

    public void printCarMoveStateLine(String line) {
        System.out.println(line);
    }

    public void printNewLine() {
        System.out.println();
    }
}
