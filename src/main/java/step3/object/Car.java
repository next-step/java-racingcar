package step3.object;

public class Car {
    private static final int MIN_AVAILABLE_CHANCE = 4;

    private String name;
    private int position = 1;

    public void move(int chance) {
        if (chance >= MIN_AVAILABLE_CHANCE){
            this.position++;
        }
    }
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Car(){
    }

    public Car(String name){
        this.name = name;
    }

    public Car(String name,
               int position) {
        this.name = name;
        this.position = position;
    }
}
