package study.step3;


public class CarRacingMain {
    public static void main(String[] args) {
        try {
            new CarRacingController().invoke();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
            throw e;
        }
    }
}
