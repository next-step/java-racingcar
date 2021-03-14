package step3;

import step3.object.Car;
import step3.util.RanDomUtil;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRaceService {
    List <Car> carList ;

    public CarRaceService() {
        carList = new ArrayList<>();
    }

    public void createCarList(int carCount){
        for(int i = 0; i< carCount ; i++){
            carList.add(new Car());
        }
    }

    public void playGame(int racingCount, ResultView resultView) {
        while(racingCount > 0){
            move();
            displayMove(resultView);
            racingCount--;
        }
    }

    private void move() {
        for(Car car : carList){
            car.go(RanDomUtil.getRandomValue());
        }
    }

    private void displayMove(ResultView resultView) {
        resultView.displayMove(carList);
    }

    public List<Car> getCarList() {
        return carList;
    }


    public void inputData(InputView inputView) {
        Scanner scan = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scan.nextInt();


        System.out.println("시도할 회수는 몇 회 인가요?");
        int racingCount = scan.nextInt();

        inputView.saveInputData(carCount, racingCount);

    }
}
