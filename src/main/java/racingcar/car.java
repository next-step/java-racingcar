package racingcar;

import java.util.Random;

public class car {

    private int move=0;
    private String name;
    Random rand = new Random();

    public car(String name){
        if(name.length()>5)
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        this.name = name;
    }

    public void go(){
        if(rand.nextInt(10)>=4)
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
