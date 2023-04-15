import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    List<Car> recordMovingCar = new ArrayList<>();

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("입력한 횟수 만큼의 '-' 문자열 만들기")
    public String moving(int randomValueForMove) {
        String move = "-";

        if (randomValueForMove > 9 || randomValueForMove < 4) {
            move = "";
            return move;
        }

        for (int number=0; number < randomValueForMove; number++) { move = move + "-";}

        return move;
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "5, 7",
            "3, 5",
            "2, 7"
    })
    @DisplayName("입력한 자동차 대수 및 시도 횟수에 맞게 결과가 출력 되는가")
    public void randomNumberForMove(int numberOfCarsValue, int numberOfAttemptsValue) {
        Random random = new Random();

        for (int attempt=0; attempt < numberOfAttemptsValue; attempt++) {
            for (int eachCar = 0; eachCar < numberOfCarsValue; eachCar++) {
                int carIndex = eachCar + 1;
                int randomValueForMove = random.nextInt(numberOfAttemptsValue);

                String move = "-";
                Car car = new Car();
                car.setMoving(move);
                recordMovingCar.add(car);

                String beforeMoving = "";

//                System.out.println("랜덤 값 : " + randomValueForMove);

                if (randomValueForMove > 9 || randomValueForMove < 4) {
                    beforeMoving = recordMovingCar.get(eachCar).getMoving();
                    String doNotMove = beforeMoving + moving(randomValueForMove);
                    car.setMoving(doNotMove);
                }

                if (randomValueForMove > 0 & randomValueForMove > 3 & randomValueForMove <= 9) {
                    beforeMoving = recordMovingCar.get(eachCar).getMoving();
                    String plusMoving = beforeMoving + moving(randomValueForMove);
                    car.setMoving(plusMoving);
                }

                recordMovingCar.add(car);
                recordMovingCar.get(eachCar).setMoving(car.getMoving());
                System.out.println(recordMovingCar.get(eachCar).getMoving());
            }
            System.out.print(System.lineSeparator());
        }
    }
}
