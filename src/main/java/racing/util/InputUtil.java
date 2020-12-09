package racing.util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public String inputNumber(){
        String inputNumber = this.scanner.nextLine();
        return inputNumber;
    }

    public String[] inputCarsName() {
        String inputNames = this.scanner.nextLine();
        String[] carsName = splitCarNames(inputNames);
        validationCars(carsName);
        return carsName;
    }


    protected String[] splitCarNames(String inputNames) {
        String[] carsName = inputNames.split(",");
        return carsName;
    }

    /**
     *  validationCheck가 통과된 carsName의 갯수
     *  validation 테스트시 반환값이 필요할 것 사용
     * @param carsName
     * @return carsName.length
     */
    protected int validationCars(String [] carsName){
        for(String carName : carsName){
            carNameLimitCharacter(carName);
        }
        return carsName.length;
    }

    protected void carNameLimitCharacter(String carName) {
        if(carName.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

}
