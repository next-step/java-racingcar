package car.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarResultTest {

    private String maxScoreCalculate(List<Car> car) {
        int maxValue = 0;
        String maxValueName = "";

        for (int i = 0; i < car.size(); i++) {
            if (maxValue < car.get(i).getPosition()) {
                maxValue = car.get(i).getPosition();
                maxValueName = car.get(i).getName();
            }
        }
        return maxValueName;
    }

    @Test
    void 최대_전진에_대해_결과를_출력한다() {
        CarList carList = new CarList(Arrays.asList(new Car("woo", 1)
                , new Car("na", 2), new Car("boo",3)));
        String maxScoreName = maxScoreCalculate(carList.getCarNameList());
        Boolean winnerCheck = maxScoreName.contains("boo");
        assertThat(winnerCheck).isTrue();
    }
}