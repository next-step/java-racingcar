package racing.domain;

public class Car {
    private final String name;
    private int position;
    
    public Car(final String name) {
        this.name = name;
    }
    
    public Car(final String name, int position) {
        this.name = name;
        this.position = position;
    }
    
    public void forward() {
        position++;
    }
    
    public String getName() {
        return name;
    }
    
    public int getPosition() {
        return position;
    }
}
