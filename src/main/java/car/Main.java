package car;

import car.controller.RacingController;

public class Main {
    public static void main(String[] args) {
        try {
            new RacingController().run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
