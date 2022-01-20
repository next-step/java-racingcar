package racingcar.model;

import racingcar.util.RandomGenerator;

public class Car {
    private String carName;
    private String position;
    public Car(String carName){
        this.carName= carName;
        this.position="";
    }

    public void moveForward(){
        RandomGenerator randomGenerator = new RandomGenerator();
        int randomNumber=randomGenerator.generateRandomNumber();
        //System.out.println(randomNumber);
        if(randomNumber>=4){
            this.position+="-";
        }

    }

    public String getCarName() {
        return carName;
    }

    public String getPosition() {
        return position;
    }
}
