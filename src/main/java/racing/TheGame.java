package racing;

import racing.view.InputView;
import racing.view.OutputView;

import java.util.Random;

public class TheGame {

    public static int round;
    public static Car[] cars;
    public static Random random;

    public TheGame(String names, int round) {
        this.cars = initCars(names);
        this.round = round;
        this.random = new Random();
    }

    public static void main(String[] args) {

        //모델분리 InputView
        InputView inputView = new InputView();

        String names = inputView.inputCarname();
        int round = inputView.inputRound();


        TheGame TheGame = new TheGame(names, round);

        //모델분리 OutputView
        OutputView outputView = new OutputView();
        String winner = outputView.winnerCar();
        System.out.println("우승자: " + winner);


    }

    public static int racing() {
        int maxPosition = 0;

        for (int i = 0; i < round; i++) {
            maxPosition = Math.max(moveCars(), maxPosition);
            printCarPosition();
        }

        return maxPosition;
    }

    public static String getWinner(int maxPosition) {
        String winnerName = "";
        int winnerCnt = 0;

        for (int i = 0; i < cars.length; i++) {

            if (cars[i].getPosition() == maxPosition) {
                winnerCnt++;
                if (winnerCnt >= 2) {
                    winnerName += ", ";
                }
                winnerName += cars[i].getName();
            }
        }

        return winnerName;
    }

    static void printCarPosition() {
        for (Car car : cars) {
            System.out.println(car.getPositionFormat());
        }
    }

    private static int moveCars() {
        int carPosistion = 0;

        for (Car car : cars) {
            /* carPosistion = Math.max(car.move(random.nextInt(10)), carPosistion);*/
            carPosistion = car.move(random.nextInt(10));
        }

        return carPosistion;
    }

    public Car[] initCars(String names) {
        String[] nameArray = names.split(",");
        Car[] cars = new Car[nameArray.length];

        for (int i = 0; i < nameArray.length; i++) {
            cars[i] = new Car(nameArray[i]);
        }

        return cars;
    }
}