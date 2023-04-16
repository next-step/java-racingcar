package racing;

public class Car {
    private static int ZERO = 0;

    private String name;
    private String movingPositionCursor = "";
    private int position;

    public Car(String name){
        this.position = ZERO;
        this.name = name;
    }

    public void move(){
        this.position++;
        this.movingPositionCursor += "-";
    }

    public int getPosition(){
        return this.position;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return name + ':' + movingPositionCursor;
    }
}
