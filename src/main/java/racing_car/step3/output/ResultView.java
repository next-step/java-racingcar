package racing_car.step3.output;

import racing_car.step3.domain.Cars;
import racing_car.step3.dto.CarDTO;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String BAR = "-";
    
    public static void resultMessagePrint() {
        System.out.println(RESULT_MESSAGE);
    }
    
    public static void processPrint(Cars cars) {
        List<CarDTO> carDTOs = cars.information();
        
        for (CarDTO carDTO : carDTOs) {
            processBarPrint(carDTO.getPosition());
        }
        System.out.println();
    }
    
    private static void processBarPrint(int position) {
        while (position-- > 0) {
            System.out.print(BAR);
        }
    }
}
