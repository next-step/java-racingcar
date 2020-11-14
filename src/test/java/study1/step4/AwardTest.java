package study1.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

public class AwardTest {

    @Test
    @DisplayName("우승자 확인")
    void WinnerListTest(){
        String first_race = "first";
        String second_race = "second";
        String third_race = "third";

        String[] racerList = {first_race, second_race, third_race};
        Decision moveGenerator = new FixedMoveDecision(10);
        Cars cars = new Cars();

        cars.initializeCars(racerList);

        Award award = new Award();

        ArrayList<String> winnerListAnswer = new ArrayList<>();
        // racer 전부 공동 우승 case
        ArrayList<String> winnerList = award.getWinnerList(cars);
        winnerListAnswer.add(first_race);
        winnerListAnswer.add(second_race);
        winnerListAnswer.add(third_race);

        assertThat(winnerList).isEqualTo(winnerListAnswer);

        List<Car> carsList = cars.getCars();

        // second racer 우승
        winnerListAnswer = new ArrayList<>();
        winnerListAnswer.add(second_race);

        Car secondCar = carsList.get(1);

        secondCar.move(moveGenerator);
        secondCar.move(moveGenerator);
        secondCar.move(moveGenerator);

        winnerList = award.getWinnerList(cars);
        assertThat(winnerList).isEqualTo(winnerListAnswer);

        // first racer, second racer 공동 우승
        winnerListAnswer = new ArrayList<>();
        winnerListAnswer.add(first_race);
        winnerListAnswer.add(second_race);

        carsList = cars.getCars();

        Car firstCar = carsList.get(0);
        firstCar.move(moveGenerator);
        firstCar.move(moveGenerator);
        firstCar.move(moveGenerator);

        winnerList = award.getWinnerList(cars);
        assertThat(winnerList).isEqualTo(winnerListAnswer);

    }
}

