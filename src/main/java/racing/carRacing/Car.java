package racing.carRacing;

public class Car {
    public static String movement = "-";

    private String step;

    public Car(String step) {
        this.step = step;
    }

    public void run(MovementStrategy strategy) {
        if (strategy.movement() >= 4) {
            step += movement;
        }
        System.out.println(step);
    }
}
