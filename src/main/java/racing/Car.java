package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Car {

    private final Scanner scanner;

    private final String firstRequest = "자동차 대수는 몇 대 인가요?";
    private final String secondRequest = "시도할 회수는 몇 회 인가요?";
    private final List<CarModel> list = new ArrayList<>();

    public Car() {
        this.scanner = new Scanner(System.in);
    }


    public void car_racing(){
        System.out.println(firstRequest);
        int totalCarNumber = scanner.nextInt();
        createCarByNumber(totalCarNumber);

    }

    private void createCarByNumber(int totalCarNumber) {
        for(int i=0;i<totalCarNumber;i++){
            CarModel carModel = new CarModel(i+1);
            list.add(carModel);
        }
    }
}
