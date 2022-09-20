package racing_car.step3.output;

import racing_car.step3.domain.Cars;
import racing_car.step3.dto.CarDTO;
import racing_car.step3.input.InputView;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    
    public static final String RESULT_MESSAGE = "실행 결과";
    public static final String BAR = "-";
    
    public static void resultMessagePrint() {
        System.out.println(RESULT_MESSAGE);
    }
    
    public static void processPrint(Cars cars) {
        List<CarDTO> carDTOs = cars.information();
        carDTOs.forEach(carDTO -> {
                    IntStream.range(0, carDTO.getPosition()).forEach(count -> System.out.print(BAR));
                    System.out.println();
                });
        System.out.println();
    }
}
