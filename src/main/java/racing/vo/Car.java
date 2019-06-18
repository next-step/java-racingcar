package racing.vo;

public class Car {
    private String name;
    private int position;
    
    public Car(String name) {
        this.name = name;
    }
    
    public Car(String name, int position) {
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
