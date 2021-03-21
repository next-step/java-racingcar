package carracing.service;

import carracing.view.ResultView;
import carracing.vo.Car;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CarRacingService {

    private final String RACING_RESULT_MARK = "-";
    private final Integer RANDOM_BOUND = 10;

    public void startRacing(Car car) {
        car.initializeRacingResult();

        for (int tryCnt = 0; tryCnt < car.getTryCount() ; tryCnt++) {
            car.setRacingResult(go(car));
            new ResultView().print(car);
        }
    }

    private List<String> go(Car car) {
        return car.getRacingResult().stream()
                .map(x -> racing(x))
                .collect(Collectors.toList());
    }

    private String racing(String result) {
        Random random = new Random();
        int randomNum = random.nextInt(RANDOM_BOUND);

        if (randomNum >= 4)
            result += RACING_RESULT_MARK;

        return result;
    }
}
