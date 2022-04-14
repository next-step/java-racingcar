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

    public int move(int number) {
        if (number < EXCESS_NUMBERS) {
            return this.distance;
        }

        return this.distance++;
    }

    public void play(int attemptNumber) {
        for (int i = 0; i < attemptNumber; i++) {
            this.move(Dice.roll());
            this.print();
        }
        System.out.println();
    }

    public void print() {
        String distanceToString = "";

        for (int i = 0; i < this.distance; i++) {
            distanceToString += "-";
        }

        System.out.println(this.getName() + " : " + distanceToString);
    }

}
