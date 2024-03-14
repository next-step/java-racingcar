package RacingGame.View;

import RacingGame.Domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    public void InputCarNumber(List<Car> carList) {
        System.out.println("How many cars?");
        int carNum = scanner.nextInt();
        updateCarList(carList, carNum);
    }

    private void updateCarList(List<Car> carList, int carNum) {
        for (int i = 0; i < carNum; i++) {
            Car car = new Car();
            carList.add(car);
        }
    }

    public int InputTrialNumber() {
        System.out.println("How many trials?");
        int trialNum = scanner.nextInt();
        return trialNum;
    }


    public void MoveCars(List<Car> carList) {
        int rval = random.nextInt(10);
        for (Car car : carList) {
            car.MoveForward(rval);
        }
    }
}
