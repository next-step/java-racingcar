package step4;

public class RacingMain {
    public static void main(String[] args) {
        try {
            InputPrint print = new InputPrint();
            String[] carNames = print.getCarNames();
            int lapCount = print.getLapCount();
            print.checkInputs(carNames, lapCount);
            new Racing(carNames, lapCount);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
