package car;

import java.util.*;
public class Car {

    private final  String carName;
    private int location = 0;


    Car(String inputName){
        if(inputName.length() >= 5 ){
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다");
        }
        this.carName = inputName ;
    }

    Car(String inputName, int location) {
        this.carName = inputName;
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return carName;
    }

    public void printLocation() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < location; i++) {
            sb.append("-");
        }
        String currentPosition = sb.toString();
        System.out.println(this.carName + " : " + currentPosition);
    }

    public void move(int randomValue) {
        if (randomValue >= 4) {
            this.location++;
        }
        printLocation();
    }

    public boolean isGreaterThan(int maxLocaton) {
        return this.location > maxLocaton;
    }

    public boolean isEqualPosition(int maxLocaton) {
        return this.location == maxLocaton;
    }

    public static int generateRandomValueBy(int condVal) {
        Random random = new Random();
        //System.out.println(random);
        return random.nextInt(condVal);
    }

}