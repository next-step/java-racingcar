package racing;

import java.util.*;

public class RacingGame {

    private static int timeToTry;
    private static int numberOfCar;
    private static List<Car> cars;

    private static final int CRITERION_TO_MOVE = 4;

    public static void inputView() {
        System.out.println("자동차 대수는 몇 대인가요?");

        Scanner scanner = new Scanner(System.in);
        numberOfCar = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회인가요?");
        timeToTry = scanner.nextInt();

    }

    public static void resultView() {

        int time = 0;

        if(time == 0) {
            System.out.println("실행 결과");
        }

        while(time < timeToTry) {
            moveCars();
            oneTryView();
            time++;
        }
    }

    public static List<Car> initCars() {
        cars = new ArrayList<Car>(numberOfCar);
        for(int i = 0 ; i < numberOfCar ; i++){
            cars.add(i, new Car());
        }
        return cars;
    }



    public static List<Car> moveCars() {
        for(int i = 0 ; i < cars.size() ; i++) {
            if (new Random().nextInt(10) >= CRITERION_TO_MOVE) {
                cars.get(i).setPosition( cars.get(i).getPosition() + 1);
            }
        }
        return cars;
    }

    public static void oneTryView() {
        for(Car car : cars) {
            for(int i = 0 ; i < car.getPosition() ; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int getTimeToTry() {
        return timeToTry;
    }

    public static int getNumberOfCar() {
        return numberOfCar;
    }


    public static void setTimeToTry(int timeToTry) {
        RacingGame.timeToTry = timeToTry;
    }

    public static void setNumberOfCar(int numberOfCar) {
        RacingGame.numberOfCar = numberOfCar;
    }

}
