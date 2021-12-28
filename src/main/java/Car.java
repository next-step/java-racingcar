import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Car {
    List<String> car = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    static final int CAR_NAME_LENGTH_BOUND =5;

    public void enterCarsName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carsName = scanner.next();
        splitCarsName(carsName);
    }

    public void splitCarsName(String carsName){
        String[] cars = carsName.split(",");
        for(int i=0; i<cars.length; i++){
            validateNameLengthCheck(cars[i]);
            car.add(cars[i]);
        }
    }

    public void validateNameLengthCheck(final String carName) {
        if (carName.length()>CAR_NAME_LENGTH_BOUND) {
            throw new IllegalArgumentException("car name is too long");
        }
    }
}
