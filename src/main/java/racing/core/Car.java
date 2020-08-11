package racing.core;

public class Car {

    public static final int CONDITION = 4;
    private String route = "";

    public String move(int random) {
        if (random >= CONDITION) {
            route += "-";
        }
        return route;
    }
}
