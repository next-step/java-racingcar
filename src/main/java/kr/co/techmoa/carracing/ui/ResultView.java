package kr.co.techmoa.carracing.ui;

import kr.co.techmoa.carracing.model.Car;
import kr.co.techmoa.carracing.ui.dto.OutputDTO;
import kr.co.techmoa.carracing.service.CarWinCheckService;

import java.util.List;

public class ResultView {

    public static final String RASCING_DISTINC = "-";
    public static final String SEPARATOR = " : ";
    public static final String SEPARATOR_WIN = " , ";
    public static final String WIN_TEXT = " 가 최종 우승했습니다.";

    public void printResult(OutputDTO outputDTO) {

        List<List<Car>> roundAll = outputDTO.getRounds();
        for(int i= 0; i< roundAll.size(); i++) {
            List<Car> round = roundAll.get(i);
            printMove(round);
        }
        List<Car> round = roundAll.get(0);
        List<Integer> winList = outputDTO.getWinList();
        System.out.println(printWin(winList , round));
    }

    public void printMove(List<Car> round) {
        for(Car car: round) {
            System.out.print(car.getCarName() + SEPARATOR);
            for(int i= 0; i< car.getPosition().getCoordinate(); i++) {
                System.out.print(RASCING_DISTINC);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public String printWin(List<Integer> cars , List<Car> round) {
        String winUser = "";
        for(int i= 0 ; i< cars.size() ; i++) {
            winUser += round.get(cars.get(i)).getCarName();
            if(i != cars.size()-1) {
                winUser += SEPARATOR_WIN;
            }
        }
        return winUser + WIN_TEXT;
    }
}
