package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Racing {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.inputView();

        racing(inputView.getCar(), inputView.getDrive());
    }

    public static void racing(int car, int number){

        List<Car> cars = ready(car);
        race(cars, number);
    }

    private static List<Car> ready(int car){
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < car; i++) {
            Car c = new Car( "-");
            cars.add(c);
        }

        return cars;
    }

    public static void run(Car car){
        Random random = new Random();

        int run = random.nextInt(10);
        if(run >= 4){
            String running = car.getRun();
            running += "-";
            car.setRun(running);
        }
    }

    private static void race(List<Car> cars, int number){
        for (int i = 0; i < number; i++) {
            for (Car car : cars) {
                if(i != 0){
                    run(car);
                }
                System.out.println(car.getRun());
            }
            System.out.println();
        }
    }
}
