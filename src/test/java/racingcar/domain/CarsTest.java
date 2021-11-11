package racingcar.domain;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {

    Cars nameCars;
    Cars countCars;
    List<CarNameInfo> nameList;

    @BeforeEach
    void setUp(){
        nameList = CarNameInfo.createListFromInput("test1,test2,test3,test4".split(","));
        nameCars = new Cars(nameList);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    @DisplayName("전달받은 size의 리스트를 생성하는지 확인")
    void sizeTest(int size){
        countCars = new Cars(size);
        assertThat(countCars.getCarList().size()).isEqualTo(size);
    }

    @Test
    @DisplayName("전달받은 이름 수만큼 차 리스트를 생성하는지 확인")
    void sizeTestWhenCreateWithNameList(){
        assertThat(nameCars.getCarList().size()).isEqualTo(4);
    }

    @Test
    @DisplayName("생성된 리스트의 Car 객체는 다 달라야한다.")
    void createDifferentObjectTest(){
        countCars = new Cars(2);
        assertThat(countCars.getCarList().get(0)).isNotSameAs(countCars.getCarList().get(1));
    }

    @Test
    @DisplayName("우승자 하나 있을 때 정확한 우승자를 가져오는지 테스트")
    void winnerTest(){
        nameCars.getCarList().get(0).forward(1);
        assertThat(nameCars.getWinnerCars().size()).isEqualTo(1);
        assertThat(nameCars.getWinnerCars().get(0).getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("우승자 여러명 있을 때 우승자 리스트 가져오는지 테스트")
    void multipleWinnerTest(){
        nameCars.getCarList().get(0).forward(1);
        nameCars.getCarList().get(1).forward(1);
        assertThat(nameCars.getWinnerCars().size()).isEqualTo(2);
        assertThat(nameCars.getWinnerCars().get(0).getPosition()).isEqualTo(1);
        assertThat(nameCars.getWinnerCars().get(1).getPosition()).isEqualTo(1);
    }
}