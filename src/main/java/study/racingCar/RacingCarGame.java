package study.racingCar;

import javax.management.RuntimeErrorException;

public class RacingCarGame {

    public static void main(String[] args){
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        StringToIntConverter converter = new StringToIntConverter();
        Car[] cars;
        int tryCount = 0;

        try{

            cars = createCarList(nameSplit(inputView.inputCarNames()));
            tryCount = converter.converter(inputView.inputTryCount());

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("시도할 횟수는 0보다 큰 숫자로만 입력해주세요.");
        }

    }


    static Car[] createCarList(String[] carNames){
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }


    static String[] nameSplit(String names){
        String[] carNames = names.split(",");
        for (String name : carNames) {
            if (name.length() > 5){
                throw new IllegalArgumentException();
            }
        }
        return carNames;
    }

}
