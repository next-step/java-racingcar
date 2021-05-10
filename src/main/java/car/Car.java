package car;

public class Car {
    private static final int MINIMUM_NUMBER = 4;

    public String name;
    public int km;

    public Car(String name, int km) {
        this.name = name;
        this.km = km;
    }

    public int getKm() {
        return this.km;
    }

    public String getName() {
        return this.name;
    }

    public void changeKm(int randomNumber) {
        if (randomNumber >= MINIMUM_NUMBER) {
            km = km + 1;
        }
    }
}
