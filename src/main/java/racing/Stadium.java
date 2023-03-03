package racing;

import java.util.Random;
import java.util.Scanner;

public class Stadium {
    public final Car[] cars;
    public final int round;

    Random random;
    public Stadium(String names, int round){

        this.cars = initCars(names);
        this.round = round;
        this.random = new Random();

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        String names = in.nextLine();

        System.out.println("시도할 회수는 몇 회인가요?");
        int round = in.nextInt();




    }

    public Car[] initCars(String names){

        String[] nameArray = names.split(",");

        Car[] cars = new Car[nameArray.length];

        for(int i = 0; i < nameArray.length; i++){
            cars[i] = new Car(nameArray[i]);
        }

        return cars;
    }

    String translatePosition(int position){

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < position; i++){
            sb.append("-");
        }

        return sb.toString();
    }

    void printCarPosition(){
        for(Car car : cars){
            System.out.println(car.name + " : " + translatePosition(car.position));
        }
    }

    void getRandomValue(){
        for(Car car : cars){
            car.move(random.nextInt());
        }
    }




}
