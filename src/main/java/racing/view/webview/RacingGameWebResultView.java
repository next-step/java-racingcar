package racing.view.webview;

import racing.dto.Car;
import racing.dto.WebRacingGameResultDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGameWebResultView {

    public static Map<String, Object> getRacingGameResultModel(List<Car> cars, List<String> winners) {
        List<WebRacingGameResultDto> resultDto = new ArrayList<WebRacingGameResultDto>();

        for (Car car : cars) {
            resultDto.add(new WebRacingGameResultDto(car.getCarName(), car.getMovePosition()));
        }
        String winnerNames = String.join(" ,", winners) + "이 우승했습니다.";

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("racingGameResult", resultDto);
        model.put("winners", winnerNames);

        return model;
    }
}
