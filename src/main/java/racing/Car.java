package racing;


public class Car {
    private static final int BASIS_RANDOM_VALUE = 4;
    private static final String MOVING = "-";
    private int position = 0;

    public void move(){
        position++;
    }

    public void turn(int number){
        if(number >= BASIS_RANDOM_VALUE) move();
    }

    public String drawPosition(){
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<position; i++){
            builder.append(MOVING);
        }
        return builder.toString();
    }
}
