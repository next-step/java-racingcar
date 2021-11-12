package study.step3;

import java.util.Random;

public class Car {
    private int number;
    private String position;
    private static String MOVE_CHARACTER = "-";
    private static int MAX_RANDOM_NUMBER = 10;
    private static int MIN_FORWARD_NUMBER = 4;


//    static {
//        ++number;
//    }

//    Car() {
//        ++number;
//    }

    public Car(int number, String position) {
        this.number = number;
        this.position = position;
    }

    void move(){
        Random random = new Random();
        int num = random.nextInt(MAX_RANDOM_NUMBER);
        if(num >= MIN_FORWARD_NUMBER){
            this.position = this.position + MOVE_CHARACTER;
        }
        System.out.println("Car number : " + this.number
                + " | random number : "  + num + " | position : "  + position);
    }

    public String getPosition(){
        return this.position;
    }

    @Override
    public String toString() {
        return "Car{" +
                "number=" + number +
                ", position='" + position + '\'' +
                '}';
    }
}
