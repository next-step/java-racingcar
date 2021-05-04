import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("화면 출력 테스트")
@TestMethodOrder(OrderAnnotation.class)
class UITest {
    Cars cars;
    UI ui;

    @BeforeEach
    void setup(){
        cars = new Cars();

        Car car1 = Car.createCar("바나나차");
        Car car2 = Car.createCar("토마토차");
        Car car3 = Car.createCar("감귤차");

        car1.run(); //winner
        car2.run(); //winner
        car3.stop();

        cars.addCar(car1);
        cars.addCar(car2);
        cars.addCar(car3);

        ui = new UI(cars);
    }

    @Test
    @Order(1)
    @DisplayName("게임 실행 결과")
    void printGameResult() {
        ui.printGameResult();
    }

    @Test
    @Order(2)
    @DisplayName("우승자 화면 출력")
    void printWinner() {
        ui.printWinner();
    }
}