package calculator.view;

public final class Output {
    private Output() {
    }

    public static void startMessageOutput() {
        System.out.println("계산식을 입력하세요.");
    }

    public static void printResult(double result) {
        System.out.print("계산 결과: ");
        System.out.print(result);
    }
}