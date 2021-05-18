package step2;

public class Car {
    private static final int NAME_LENGTH = 5;
    private static final int MOVE = 4;

    private int position;
    public Car(String jason) {
        if(jason.length() > 5){
            throw new IllegalArgumentException();
        }
    }

    public void move(int number) {
        if(number>4){
            position++;
        }
    }


    public int getPosition() {
        return position;
    }
}
