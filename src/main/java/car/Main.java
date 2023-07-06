package car;

public class Main {

    public static void main(String[] args) {
        RacingService racingService = new RacingService();

        try {
            racingService.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
