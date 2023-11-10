package study.racingCar;

import static study.racingCar.StringToIntConverter.stringToIntConverter;

public class Controller {


    public static void main(String[] args){
        int cars = 0;
        int rounds = 0;
        InputView inputView = new InputView();

        try{

            cars = stringToIntConverter(inputView.inputCars());
            rounds = stringToIntConverter(inputView.inputRounds());

            System.out.println("cars: "+cars);
            System.out.println("rounds: "+rounds);


        }catch (Exception e){
            e.printStackTrace();
            System.out.println("숫자 양수로만 입력해주세요.");
        }

    }

}
