package study.racingCar;

import static study.racingCar.InputView.inputCars;
import static study.racingCar.InputView.inputRounds;
import static study.racingCar.RacingModel.roundRun;
import static study.racingCar.StringToIntConverter.stringToIntConverter;

public class Controller {


    public static void main(String[] args){
        int cars = 0;
        int rounds = 0;
        Car[] carList;

        try{

            String str = inputCars();
            String rnds = inputRounds();

            carList = new Car[cars];

            System.out.println("cars: "+cars);
            System.out.println("rounds: "+rounds);


            for (int i = 0; i < cars; i++) {
                carList[i] = new Car();
            }

            for (int i = 0; i < rounds; i++) {
                for (Car car : carList) {
                    car.carAddPosition(roundRun(car.randomNum()));
                }
                System.out.println();
            }



        }catch (Exception e){
            e.printStackTrace();
            System.out.println("숫자 양수로만 입력해주세요.");
        }

    }

}
