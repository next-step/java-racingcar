package car;

public class Car {
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

    public void changeKm(int km) {
        this.km = km;
    }
}
