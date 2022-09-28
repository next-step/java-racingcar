package ThirdStep.view;

import ThirdStep.domain.model.Car;
import ThirdStep.domain.model.RecordByCar;
import ThirdStep.domain.model.request.CarRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RecordPrintServiceTest {
    private final RecordPrintService recordPrintService = new RecordPrintService();
    private Method getWinnersMethod;

    private final List<RecordByCar> recordByCars = new ArrayList<>();

    @BeforeEach
    public void setGetWinnersMethod() throws NoSuchMethodException {
        getWinnersMethod = recordPrintService.getClass().getDeclaredMethod("getWinners", List.class);
        getWinnersMethod.setAccessible(true);
    }

    @BeforeEach
    public void setCars() {
        Car car1 = new Car(new CarRequest("car1"));
        Car car2 = new Car(new CarRequest("car2"));
        Car car3 = new Car(new CarRequest("car3"));

        recordByCars.add(new RecordByCar(car1, 10));
        recordByCars.add(new RecordByCar(car2, 15));
        recordByCars.add(new RecordByCar(car3, 5));
    }

    @Test
    @DisplayName("가장 멀리 간 차가 한 대인 경우, 승자는 1명이고 이름은 car2이다.")
    void test1() throws InvocationTargetException, IllegalAccessException {
        List<Car> winner = (List<Car>) getWinnersMethod.invoke(recordPrintService, recordByCars);

        assertThat(winner.size()).isEqualTo(1);
        assertThat(winner.get(0).getName()).isEqualTo("car2");
    }

    @Test
    @DisplayName("가장 멀리간 차가 두 대인 경우, 승자는 2명이고 이름은 car2, car4이다.")
    void test2() throws InvocationTargetException, IllegalAccessException {
        Car car4 = new Car(new CarRequest("car4"));
        recordByCars.add(new RecordByCar(car4, 15));

        List<Car> winner = (List<Car>) getWinnersMethod.invoke(recordPrintService, recordByCars);

        assertThat(winner.size()).isEqualTo(2);
        assertThat(winner.get(0).getName()).isEqualTo("car2");
        assertThat(winner.get(1).getName()).isEqualTo("car4");
    }

}
