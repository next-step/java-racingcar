package Model;

import java.util.Random;

public class Car {
    private String name;
    private int distance;

    public Car(String name){
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public void setDistance(int testNum){
        this.distance = testNum;
    }

    public int getDistance() {
        return distance;
    }

    public void move(){
        int num = new Random().nextInt(10);
        if(num >= 4) distance += 1;
    }

    public void move(int testNum){
        if(testNum >= 4) distance += 1;
    }

    public String toString(){
        String str = "";
        for(int i = 0; i < distance; i++)
                str = str.concat("-");

        return name + " : " + str;
    }
}
