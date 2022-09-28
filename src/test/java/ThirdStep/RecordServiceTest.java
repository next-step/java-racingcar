package ThirdStep;

import ThirdStep.domain.model.Car;
import ThirdStep.domain.model.request.CarRequest;
import ThirdStep.domain.model.RecordByCar;
import ThirdStep.domain.RecordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RecordServiceTest {


    private static final int START_LOCATION = 0;

    private final List<Car> cars = new ArrayList<>();
    private final List<RecordByCar> recordByCars = new ArrayList<>();

    private final RecordService recordService = new RecordService();

    @BeforeEach
    public void setCarAndRecordByCars() {
        Car car1 = new Car(new CarRequest("car1"));
        Car car2 = new Car(new CarRequest("car2"));
        Car car3 = new Car(new CarRequest("car3"));

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        recordByCars.add(new RecordByCar(car1, 10));
        recordByCars.add(new RecordByCar(car2, 15));
        recordByCars.add(new RecordByCar(car3, 5));
    }

    @Test
    @DisplayName("car리스트를 전달하면 현재 위치가 0인 RecordByCar 리스트를 반환한다.")
    void test1() {
        List<RecordByCar> responses = recordService.initRecordByCars(cars);

        responses.forEach(res -> assertThat(res.getLocation()).isEqualTo(START_LOCATION));
    }


}
