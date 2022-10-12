package step5.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.service.RacingWinnerService;

class RacingWinnerServiceTest {

    private List<Car> cars;

    @BeforeEach
    void setUp(){
        CarName firstCarName = new CarName("suchan");
        CarName secondCarName = new CarName("pob");
        CarName thirdCarName = new CarName("jon");

        cars = Arrays.asList(
                new Car(firstCarName),
                new Car(secondCarName),
                new Car(thirdCarName)
        );
    }

    @Test
    @DisplayName("chooserWinner()로 우승자 문자열을 구한다.")
    void chooseWinner_String(){
        List<RacingResult> racingResults = new ArrayList<>();
        for (Car car : cars) {
            car.moveForward();
            racingResults.add(new RacingResult(car));
        };

        String winner = RacingWinnerService.chooseWinner(racingResults);

        Assertions.assertThat(winner).isEqualTo("suchan,pob,jon");
    }
}