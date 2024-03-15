package racing_winner.domain;


import java.util.Objects;

public class Car {
    private static final String LOCATION_TOKEN = "-";

    private static final int MAX_INT = 4;
    private int level;

    private final String name;
    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int max(int input) {
        return Math.max(this.level, input);
    }

    public boolean isMatch(int input){
        return input == level;
    }

    public void tryMove(int nextInt) {
        if (nextInt < MAX_INT)
            level++;
    }

    public String getStatus() {
        return name + " : " + LOCATION_TOKEN.repeat(level);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Car car = (Car) obj;

        return (Objects.equals(this.name, car.name)) && this.level == car.level;
    }
}
