package study.racingCar;

import static study.racingCar.ResultView.printRacing;
import static study.racingCar.StringToIntConverter.stringToIntConverter;

public class Controller {


    public static void main(String[] args){
        RacingModel model = new RacingModel();
        InputView inputView = new InputView();

        int cars = 0;
        int rounds = 0;
        Car[] carList;

        try{

            cars = stringToIntConverter(inputView.inputCars());
            rounds = stringToIntConverter(inputView.inputRounds());

            carList = new Car[cars];

            for (int i = 0; i < cars; i++) {
                carList[i] = new Car();
            }

            for (int i = 0; i < rounds; i++) {
                System.out.println("round:" + i);

                for (int j = 0; j < cars; j++) {
                    System.out.println("car: " + j);
                    Position p = carList[j].currentPosition();
                    p = p.increase(model.randomNum());
                    carList[j] = new Car(p.position());
                    printRacing(p.position());
                    System.out.println();
                }
                System.out.println();
            }



        }catch (Exception e){
            e.printStackTrace();
            System.out.println("숫자 양수로만 입력해주세요.");
        }

    }

}
