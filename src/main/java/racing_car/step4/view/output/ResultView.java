package racing_car.step4.view.output;

import racing_car.step4.domain.Cars;
import racing_car.step4.dto.CarDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String BAR = "-";
    public static final String COLON = " : ";
    
    public static void resultMessagePrint() {
        System.out.println(RESULT_MESSAGE);
    }
    
    public static void processPrint(Cars cars) {
        List<CarDTO> carDTOs = cars.information();
        
        for (CarDTO carDTO : carDTOs) {
            System.out.print(carDTO.getName() + COLON);
            processBarPrint(carDTO.getPosition());
        }
        System.out.println();
    }
    
    private static void processBarPrint(int position) {
        while (position-- > 0) {
            System.out.print(BAR);
        }
        System.out.println();
    }
    
    public static void winnersPrint(Cars cars) {
        System.out.println(String.join(", ", getWinnersNameList(cars)) + "가 최종 우승했습니다.");
    }
    
    private static List<String> getWinnersNameList(Cars cars) {
        return cars.findWinners().stream()
                .map(CarDTO::getName)
                .collect(Collectors.toList());
    }
}
