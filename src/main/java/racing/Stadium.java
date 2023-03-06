package racing;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Stadium {
    public final Car[] cars;
    public final int round;
    private Random random;

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
        int round = Integer.parseInt(in.nextLine());

        Stadium stadium = new Stadium(names, round);

        System.out.println("실행 결과");
        int winnerPosition = stadium.racing();

        System.out.println("최종 우승자: "+stadium.getWinner(winnerPosition));
    }

    public Car[] initCars(String names){

        String[] nameArray = names.split(",");

        Car[] cars = new Car[nameArray.length];

        for(int i = 0; i < nameArray.length; i++){
            cars[i] = new Car(nameArray[i]);
        }

        return cars;
    }

    void printCarPosition(){
        for(Car car : cars){
            System.out.println(car.getPositionFormat());
        }
    }

    private int moveCars(){
        int carPosistion = 0;

        for(Car car : cars){
            carPosistion = Math.max(car.move(random.nextInt()), carPosistion);
        }

        return carPosistion;
    }

    public int racing(){
        int maxPosition = 0;

        for(int i = 0; i < round; i++){
            maxPosition = Math.max(moveCars(), maxPosition);
            printCarPosition();
            System.out.println();
        }

        return maxPosition;
    }

    private String getWinner(int maxPosition) {

        return Arrays.stream(cars)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

}
