package racing;

public class Car {
    public final static int DEFAULT_POSITION = 0;
    
    private String name;
    private int position;
    
    public Car(String name) {
        this.name = name;
        this.position = DEFAULT_POSITION;
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
