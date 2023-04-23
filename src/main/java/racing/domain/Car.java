package racing.domain;

public class Car {
    private static final int FORWARD_NUM = 4;

    private Name name;
    private Position position;


    public Car(String name){
        this(name, 0);
    }

    public Car(String name, int position){
        this.position = new Position(position);
        this.name = new Name(name);
    }

    public void move(int randomNo) {
        if(randomNo > FORWARD_NUM){
            position.move();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public String toString() {
        return name.getName() + ":" + position.getPositionDash();
    }

}
