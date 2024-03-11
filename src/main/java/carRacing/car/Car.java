package carRacing.car;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private int position = 0;
    private String name;

    protected Car(){}

    private Car(String name)  {
        this.name = name;
    }

    public static Car of(String name) throws IllegalAccessException {
        if(name.length() > 5){
            throw new IllegalAccessException("이름은 5자를 초과할 수 없습니다.");
        }
        return new Car(name);
    }

    public void updatePosition(int randomNum){
        if(isMovable(randomNum))
            position++;
    }

    private boolean isMovable(int randomNum){
        return randomNum >= MOVE_THRESHOLD;
    }

    public int getPosition(){
        return this.position;
    }

    public String getName(){
        return this.name;
    }
}
