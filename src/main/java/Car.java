import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Car {
    List<String> car = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void enterCarsName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carsName = scanner.next();
        splitCarsName(carsName);
    }

    public void splitCarsName(String carsName){
        String[] cars = carsName.split(",");
        for(int i=0; i<cars.length; i++){
            car.add(cars[i]);
        }
    }
}
