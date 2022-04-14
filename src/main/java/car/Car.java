package car;

public class Car {
    public static final int EXCESS_NUMBERS = 4;
    private String name;
    private int distance;

    public Car(String name)  {
        if (name.length() > 5) {
            throw new RuntimeException("이름은 5자를 초과할 수 없습니다");
        }

        this.distance = 0;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    public String move(int number) {
        if (number < EXCESS_NUMBERS) {
            return "";
        }

        this.distance++;
        return this.print();
    }

    public String print() {
        String distanceToString = "";

        for (int i = 0; i < this.distance; i++) {
            distanceToString += "-";
        }

        return distanceToString;
    }

}
