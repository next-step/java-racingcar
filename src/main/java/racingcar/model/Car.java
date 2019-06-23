package racingcar.model;

import racingcar.utils.NumGenerator;

public class Car {
    private final int GO_CONDITION = 4;
    private String name;
    private int position;
    private NumGenerator randomNum;

    private Car(){

    }

    public Car(String name, int position, NumGenerator randomNum){
        this.name = name;
        this.position = position;
        this.randomNum = randomNum;

    }

    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }

    public int getRandomNum(){
        return randomNum.nextInt();
    }

    public void move(){
        if(getRandomNum() > GO_CONDITION) {
            this.position++;
        }
    }
}
