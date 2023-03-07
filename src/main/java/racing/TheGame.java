package racing;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheGame {
    public final Car[] cars;
    public final int round;
    private Random random;

    public TheGame(String names, int round){
        this.cars = initCars(names);
        this.round = round;
        this.random = new Random();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("자동차 이름을 입력하세요(쉼표(,)구분");
        String names = in.nextLine();

        System.out.println("시도할 회수를 입력하세요!");
        int round = Integer.parseInt(in.nextLine());

        TheGame TheGame = new TheGame(names, round);

        System.out.println("실행결과");
        int winnerPosition = TheGame.racing();

        System.out.println("우승자: "+TheGame.getWinner(winnerPosition));
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
            System.out.println("maxPosition : "+maxPosition);
        }

        return maxPosition;
    }

    private String getWinner(int maxPosition) {
        /*흠.. 이부분 구현 추가 필요*/
        return Arrays.stream(cars)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

}