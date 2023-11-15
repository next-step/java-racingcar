package study.racingCar;

import static study.racingCar.ResultView.printRacing;
import static study.racingCar.StringToIntConverter.stringToIntConverter;

public class Controller {


    public static void main(String[] args){
        InputView inputView = new InputView();
        PlayCarRacingGame game = new PlayCarRacingGame();

        int cars = 0;
        int rounds = 0;

        try{

            cars = stringToIntConverter(inputView.inputCars());
            rounds = stringToIntConverter(inputView.inputRounds());

            CarList carList = new CarList(cars);

            for (int i = 0; i < rounds; i++) {
                game.play(cars, carList);
                System.out.println();
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("숫자 양수로만 입력해주세요.");
        }

    }

}
