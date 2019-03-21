package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class WebResultView {

    private final String SPACE_STR = "&nbsp;";

    public List<WebRacingResult> webResults(List<Car> cars) {
        List<WebRacingResult> webRacingResults = new ArrayList<>();
        for (Car car : cars) {
            webRacingResults.add(webResult(car));
        }

        return webRacingResults;
    }

    private WebRacingResult webResult(Car car) {
        int position = car.getPosition();
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < position; i++) {
            stringBuffer.append(SPACE_STR);
        }

        return new WebRacingResult(car, stringBuffer.toString());
    }

    public String webWinner(List<Car> winners) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            builder.append(winners.get(i).getCarName());
            builder.append(", ");
        }

        String result = builder.toString();
        int lastIndex = result.lastIndexOf(",");
        result = result.substring(0, lastIndex);

        return result;
    }
}
