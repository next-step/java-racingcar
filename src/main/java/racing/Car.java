package racing;


public class Car {
    private static final int BASIS_RANDOM_VALUE = 4;
    private int position = 0;

    public void move(){
        position++;
    }

    public void turn(NumberGenerator numberGenerator){
        final int number = numberGenerator.generate();
        if(number >= BASIS_RANDOM_VALUE) move();
    }

    public int getPosition(){
        return position;
    }
}
