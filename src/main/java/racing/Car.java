package racing;

public class Car {
    private String name;
    private int position;
    
    public Car(int name) {
        this.name = String.valueOf(name);
    }
    
    public String getName() {
        return name;
    }
}
