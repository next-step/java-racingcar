package step3;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    private final String PRINT_EXPRESSION_STR = "-";

    private List<CarResultDto> carRacingResult;

    public ResultView() {
        System.out.println("실행 결과");
        this.carRacingResult = new ArrayList<>();
    }

    public void addCarRacingResult(CarResultDto carResult) {
        carRacingResult.add(carResult);
    }

    public void printOutRacingResult() {
        carRacingResult.forEach(carResultDto -> {
            carResultDto.getCarResultList()
                    .forEach(car -> System.out.println(StringUtil.repeat(PRINT_EXPRESSION_STR, car.getCurrentPosition())));
            System.out.println();
        });
    }

}
