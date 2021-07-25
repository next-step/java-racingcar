package racing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.car.entity.*;
import racing.domain.car.entity.fake.FakeBasicCar;
import racing.view.DosResultView;
import racing.view.FakeInputView;
import racing.view.InputView;


class RacingSolutionTest {
    private static CarsTest carsTest;

    @BeforeAll
    public static void setUp() {
        carsTest = new CarsTest();
    }

    @DisplayName("Run Test")
    @CsvSource({
            "A|B|C,D,100",
            "A|B|C,D|E,100",
            "A|B|C|D|E|F,G|P|Q,100"
    })
    @ParameterizedTest
    public void runTest(String strBasicCarNames, String strFakeCarNames, int turnSize) {
        Cars cars = carsTest.initCars(strBasicCarNames, BasicCar::new);
        // fake car 추가
        for (Car iDreamCar : carsTest.initCars(strFakeCarNames, FakeBasicCar::new))
            cars.add(iDreamCar);

        InputView inputView = new FakeInputView(cars, turnSize);
        RacingController racingSolution = new RacingController(
                inputView, new DosResultView()
        );

        racingSolution.run();
    }
}