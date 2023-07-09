package car;

public class Main {

    public static void main(String[] args) {

        try {
            new RacingService().run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
