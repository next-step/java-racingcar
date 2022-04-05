package step02;

public class OutputView {

    public void printNumber(Number number) {
        System.out.println(number.getNumber());
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printQuitMessage() {
        System.out.println("프로그램을 종료합니다.");
    }

}
