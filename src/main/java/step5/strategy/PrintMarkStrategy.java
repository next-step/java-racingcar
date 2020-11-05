package step5.strategy;

public class PrintMarkStrategy {
    private String printMark;

    public PrintMarkStrategy(String printMark) {
        this.printMark = printMark;
    }

    public void updateMark(String mark) {
        if (!printMark.equals(mark)) {
            printMark = mark;
        }
    }

    public String getPrintMark() {
        return printMark;
    }
}
