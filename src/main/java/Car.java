import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Car {
    public static List<String> cars = new ArrayList<>();
    public static List<String> carsMoving = new ArrayList<>();
    static final int CAR_NAME_LENGTH_BOUND =5;
    static final int CAR_MOVE =4;

    Scanner scanner = new Scanner(System.in);

    public void enterCarsName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carsName = scanner.next();
        splitCarsName(carsName);
    }

    public void splitCarsName(String carsName){
        String[] carsList = carsName.split(",");
        for(int i=0; i<carsList.length; i++){
            validateNameLengthCheck(carsList[i]);
            cars.add(carsList[i]);
            carsMoving.add("");
        }
    }

    public void validateNameLengthCheck(final String carName) {
        if (carName.length()>CAR_NAME_LENGTH_BOUND) {
            throw new IllegalArgumentException("car name is too long");
        }
    }

    public void carsMove(int carIndex, int randomNumber){
        if(randomNumber>=CAR_MOVE){
            String newMove = carsMoving.get(carIndex) +"-";
            carsMoving.set(carIndex, newMove);
        }
    }
}
