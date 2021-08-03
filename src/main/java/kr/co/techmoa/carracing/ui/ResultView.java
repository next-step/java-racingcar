package kr.co.techmoa.carracing.ui;

import kr.co.techmoa.carracing.model.Car;
import kr.co.techmoa.carracing.model.RacingCarGame;
import kr.co.techmoa.carracing.service.CarWinCheckService;

import java.util.List;

public class ResultView {

    public static final String RASCING_DISTINC = "-";
    public static final String SEPARATOR = " : ";
    public static final String SEPARATOR_WIN = " , ";
    public static final String WIN_TEXT = " 가 최종 우승했습니다.";

    public void printResult(RacingCarGame racingCarGame) {

        List<Car[]> carList = racingCarGame.getRounds();

        for(int i = 0 ; i < carList.size() ; i++) {
            Car[] cars = carList.get(i);
            printMove(cars);
        }

        CarWinCheckService carWinCheckService = new CarWinCheckService();
        List<Car> winList = carWinCheckService.checkGameResult(carList);
        System.out.println(printWin(winList));
    }

    public void printMove(Car[] cars) {
        for(Car car: cars) {
            print(car);
        }
        System.out.println("");
    }

    public void print(Car car) {
        System.out.print(car.getCarName() + SEPARATOR);
        for(int i = 0 ; i < car.getTotalMove() ; i++) {
            System.out.print(RASCING_DISTINC);
        }
        System.out.println("");

    }

    public String printWin(List<Car> cars) {
        String winUser = "";
        for(int i = 0 ; i < cars.size() ; i++) {
            winUser += cars.get(i).getCarName();
            if(i != cars.size()-1) {
                winUser += SEPARATOR_WIN;
            }
        }
        return winUser + WIN_TEXT;
    }
}
