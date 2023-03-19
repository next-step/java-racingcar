package racingcar_first;

import java.util.Random;

public class Car {

    private int move=0;
    private final int DEFAULT_POSITON=5;
    private final int NAME_MAX_LENGTH_EXCLUSIVE = 10;
    private final int GO_CONDITION_NUMBER = 4;

    private String name;
    private Random rand = new Random();

    public Car(String name){
        if(name.length()>DEFAULT_POSITON)
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        this.name = name;
    }

    public void go(){
        if(rand.nextInt(NAME_MAX_LENGTH_EXCLUSIVE)>=GO_CONDITION_NUMBER)
            this.move+=1;
    }

    int result(){
        return this.move;
    }

    String name(){
        return this.name;
    }

    public void showrace(){
        System.out.print(this.name + " : ");
        for(int i=0 ; i<move ; i++) System.out.print("-");
        System.out.println("");
    }
}
