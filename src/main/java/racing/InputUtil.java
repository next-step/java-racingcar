package racing;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public String inputNumber(){
        String inputNumber = this.scanner.nextLine();
        return inputNumber;
    }

    public String[] inputCarsName() {
        String inputNames = this.scanner.nextLine();
        String[] carsName = inputNames.split(",");
        validationCars(carsName);
        return carsName;
    }

    private void validationCars(String [] carsName){
        for(String car : carsName){
            carNameLimitCharacter(car);
        }
    }

    private void carNameLimitCharacter(String car) {
        if(car.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

}
