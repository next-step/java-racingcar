package racingcar.domain;


import java.util.Random;

public class Car {

    private static  final  int  MAXMUM_NAME_LENGTH = 5;
    private static final  int DEFAULT_POSITION= 0;
    private final String name;
    private int position ;

    public Car(final String name ){
        this(name,DEFAULT_POSITION);

    }
    public Car(final String name , final int i ){
        if(name.length() > MAXMUM_NAME_LENGTH){
            throw new IllegalArgumentException("자동차의 이름은 5글자를 넘을 수 없습니다.");
        }
        this.name= name;
        this.position = i;

    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }


    public void move() {
        Random random = new Random();
        final int randomNumber = getRandom();
        move(randomNumber);
    }
    protected int getRandom() {
        return new Random().nextInt(10);
    }

    public  void move (final int randomnumber){
        if(randomnumber > 4){
            position++;
        }

    }
}

