//package step3;
//
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import step3.domain.Car;
//import step3.controller.RacingGame;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class RacingGameTest {
//
//    @ParameterizedTest(name = "List<Car> 초기화 테스트")
//    @CsvSource({"3,3", "3,4", "3,5", "4,4", "4,5", "5,5"})
//    void setCars(int numberOfCars, int attemps) {
//        // given
//        List<Car> carList = new ArrayList<>();
//        for (int i = 0; i < numberOfCars; i++) {
//            carList.add(new Car(rule));
//        }
//
//        int expected = numberOfCars;
//
//        // when
//        RacingGame race = new RacingGame(numberOfCars, attemps);
//        int actual = race.setCars().size();
//
//        // then
//        assertEquals(actual, expected);
//    }
//
//    @ParameterizedTest(name = "RacingGame 에서 필드를 제대로 가져오는지 테스트")
//    @CsvSource({"3,3", "3,4", "3,5", "4,4", "4,5", "5,5"})
//    void getAttemps(int numberOfCars, int attemps) {
//        // given
//        RacingGame race = new RacingGame(numberOfCars, attemps);
//
//        int expected = attemps;
//
//        // when
//        int actual = race.getAttemps();
//
//        // then
//        assertEquals(actual, expected);
//    }
//}
