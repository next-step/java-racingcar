package racing.refactor.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.refactor.dto.RequestGameCreation;
import racing.refactor.dto.ResponseCar;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Car <-> Dto 변환 Builder 테스트")
class CarBuilderTest {

    @Test
    @DisplayName("Dto 를 Entity 로 변환 결과, 예상 데이터와 같을 때 성공")
    public void requestDtoToEntityWithOk() {
        List<String> requestNames = Arrays.asList("van", "kan", "tony");
        int requestLoopCount = 5;
        RequestGameCreation dto = new RequestGameCreation(requestNames, requestLoopCount);

        List<Car> desiredResult = Arrays.asList(
                 new Car("van", 0)
                ,new Car("kan", 0)
                ,new Car("tony", 0)
        );

        List<Car> resultCars = CarBuilder.toCar(dto);

        assertAll(
                 () -> assertEquals(desiredResult, resultCars)
                ,() -> assertEquals(desiredResult.size(), resultCars.size())
        );
    }

    @Test
    @DisplayName("Dto 를 Entity 로 변환 결과, 예상 데이터와 다를 때 실패")
    public void requestDtoToEntityWithFail() {
        List<String> requestNames = Arrays.asList("van", "kan", "tony");
        int requestLoopCount = 5;
        RequestGameCreation dto = new RequestGameCreation(requestNames, requestLoopCount);

        List<Car> desiredResult = Arrays.asList(
                 new Car("van1")
                ,new Car("kan1")
                ,new Car("tony1")
        );

        List<Car> resultCars = CarBuilder.toCar(dto);

        assertNotEquals(desiredResult, resultCars);
        assertEquals(desiredResult.size(), resultCars.size());
    }

    @Test
    @DisplayName("Entity 를 Dto 로 변환 결과, 예상 데이터와 같을 때 성공")
    public void entityToRequestDtoWithOk() {
        List<Car> cars = Arrays.asList(
                 new Car("van")
                ,new Car("kan")
                ,new Car("tony")
        );

        List<ResponseCar> desiredResult = Arrays.asList(
                 new ResponseCar("van", 0)
                ,new ResponseCar("kan", 0)
                ,new ResponseCar("tony", 0)
        );

        List<ResponseCar> resultDto = CarBuilder.toCarInformation(cars);

        assertEquals(desiredResult, resultDto);
        assertEquals(desiredResult.size(), resultDto.size());
    }

    @Test
    @DisplayName("Entity 를 Dto 로 변환 결과, 예상 데이터와 다를 때 실패")
    public void entityToRequestDtoWithFail() {
        List<Car> cars = Arrays.asList(
                 new Car("van")
                ,new Car("kan")
                ,new Car("tony")
        );

        List<ResponseCar> desiredResult = Arrays.asList(
                 new ResponseCar("van", 1)
                ,new ResponseCar("kan", 2)
                ,new ResponseCar("tony", 3)
        );

        List<ResponseCar> resultDto = CarBuilder.toCarInformation(cars);

        assertNotEquals(desiredResult, resultDto);
    }
}