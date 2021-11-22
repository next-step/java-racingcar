package racing.winner.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.winner.resolver.CarDto.Request;
import racing.winner.resolver.CarDto.Response;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Car <-> Dto 변환 Builder 테스트")
class CarBuilderTest {

    @Test
    @DisplayName("Dto 를 Entity 로 변환 결과, 예상 데이터와 같을 때 성공")
    public void requestDtoToEntityWithOk() {
        List<String> requestNames = Arrays.asList("pollra", "henry", "tony");
        int requestLoopCount = 5;
        Request.GameCreation dto = new Request.GameCreation(requestNames, requestLoopCount);

        List<Car> desiredResult = Arrays.asList(
                 new Car("pollra")
                ,new Car("henry")
                ,new Car("tony")
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
        List<String> requestNames = Arrays.asList("pollra", "henry", "tony");
        int requestLoopCount = 5;
        Request.GameCreation dto = new Request.GameCreation(requestNames, requestLoopCount);

        List<Car> desiredResult = Arrays.asList(
                 new Car("pollra1")
                ,new Car("henry1")
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
                 new Car("pollra")
                ,new Car("henry")
                ,new Car("tony")
        );

        List<Response.CarInformation> desiredResult = Arrays.asList(
                 new Response.CarInformation("pollra", 0)
                ,new Response.CarInformation("henry", 0)
                ,new Response.CarInformation("tony", 0)
        );

        List<Response.CarInformation> resultDto = CarBuilder.toCarInformation(cars);

        assertEquals(desiredResult, resultDto);
        assertEquals(desiredResult.size(), resultDto.size());
    }

    @Test
    @DisplayName("Entity 를 Dto 로 변환 결과, 예상 데이터와 다를 때 실패")
    public void entityToRequestDtoWithFail() {
        List<Car> cars = Arrays.asList(
                new Car("pollra")
                ,new Car("henry")
                ,new Car("tony")
        );

        List<Response.CarInformation> desiredResult = Arrays.asList(
                 new Response.CarInformation("pollra", 1)
                ,new Response.CarInformation("henry", 2)
                ,new Response.CarInformation("tony", 3)
        );

        List<Response.CarInformation> resultDto = CarBuilder.toCarInformation(cars);

        assertNotEquals(desiredResult, resultDto);
    }
}