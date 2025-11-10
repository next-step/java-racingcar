package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    private String run;

    public Car(String run) {
        this.run = run;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run){
        this.run = run;
    }

    public static List<Car> set(int car){
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
}
