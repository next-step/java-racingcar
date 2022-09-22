package racing_car.step4.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing_car.step4.dto.CarDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private List<Car> carsList;
    private List<Car> carsListPositionDiff;
    private Name jun;
    private Name pobi;
    private Name young;
    
    @BeforeEach
    void setUp() {
        jun = new Name("jun");
        pobi = new Name("pobi");
        young = new Name("young");
        Position zeroPosition = new Position(0);
        carsList = Arrays.asList(new Car(jun, zeroPosition), new Car(pobi, zeroPosition), new Car(young, zeroPosition));
        carsListPositionDiff = Arrays.asList(new Car(jun, new Position(4)), new Car(pobi, new Position(5)), new Car(young, new Position(2)));
    }
    
    @Test
    @DisplayName("차량 객체 생성")
    void createCars() {
        assertThat(new Cars(carsList)).isEqualTo(new Cars(CarsFactory.from(new String[]{"jun", "pobi", "young"})));
    }
    
    @DisplayName("차량들의 정보(CarDTO) 확인")
    @ParameterizedTest(name = "{displayName} : index = {0}, position : {1}")
    @CsvSource(value = {"0:4", "1:5", "2:2"}, delimiter = ':')
    void carInfo(int idx, int position) {
        List<CarDTO> carDTOS = new Cars(carsListPositionDiff).information();
        assertThat(carDTOS.get(idx).getPosition()).isEqualTo(position);
    }
    
    @Test
    @DisplayName("차량 이동 여부 확인")
    void moveTry() {
        Cars cars = new Cars(carsList);
        Position twoPosition = new Position(2);
        List<Car> tmpCarsList = Arrays.asList(new Car(jun, twoPosition), new Car(pobi, twoPosition), new Car(young, twoPosition));
        
        cars = new Cars(cars.tryMove(() -> true));
        cars = new Cars(cars.tryMove(() -> true));
        
        assertThat(cars).isEqualTo(new Cars(tmpCarsList));
    }
    
    @Test
    @DisplayName("우승자 한 명")
    void winnerOne() {
        Cars cars = new Cars(carsListPositionDiff);
        List<String> winners = cars.findWinners().stream()
                .map(CarDTO::getName)
                .collect(Collectors.toList());
        assertThat(winners).hasSize(1).isEqualTo(List.of("pobi"));
    }
    
    @Test
    @DisplayName("우승자 여러 명")
    void winnerTwo() {
        Cars cars = new Cars(Arrays.asList(new Car(jun, new Position(5)), new Car(pobi, new Position(5)), new Car(young, new Position(2))));
        List<String> winners = cars.findWinners().stream()
                .map(CarDTO::getName)
                .collect(Collectors.toList());
        assertThat(winners).hasSize(2).isEqualTo(List.of("jun", "pobi"));
    }
}