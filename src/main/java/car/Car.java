package car;

public class Car {
    public static final int EXCESS_NUMBERS = 4;
    private String name;
    private StringBuilder distance;

    public Car(String name)  {
        if (name.length() > 5) {
            throw new RuntimeException("이름은 5자를 초과할 수 없습니다");
        }

        this.distance = new StringBuilder();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getDistance() {
        return this.distance.toString();
    }

    public String move(int number) {
        if (number < EXCESS_NUMBERS) {
            return "";
        }

        this.distance.append("-");
        return this.distance.toString();
    }

    public void print() {

    }

}
