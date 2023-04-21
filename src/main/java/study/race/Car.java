package study.race;

public class Car {
    int position = 0;

    public Car() {
    }

    public static int condition(int random) {
        if (random >= 4) {
            return 1;
        }
        return 0;
    }
}