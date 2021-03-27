package step3;

public class RacingMain {
    public static void main(String[] args) {
        try {
            InputPrint print = new InputPrint();
            int carCount = print.getCarCount();
            int lapCount = print.getLapCount();
            print.checkInputs(carCount, lapCount);
            new Racing(carCount, lapCount);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
