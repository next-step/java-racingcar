package racing;


public class Car {
    private static final int BASIS_RANDOM_VALUE = 4;
    private int position = 0;
    private String name;

    Car(){}

    Car(String name){
        this.name = name;
    }

    public void move(){
        this.position++;
    }

    public void turn(NumberGenerator numberGenerator){
        final int number = numberGenerator.generate();
        if(number >= BASIS_RANDOM_VALUE) move();
    }

    public int getPosition(){
        return this.position;
    }

    public String getName(){
        return this.name;
    }
}
