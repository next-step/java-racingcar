package domain.car;

public class Car {
    public static final int EXCESS_NUMBERS = 4;
    private Name name;
    private int distance;

    public Car(String name)  {
        this.distance = 0;
        this.name = new Name(name);
    }

    public String getName() {
        return this.name.value();
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
