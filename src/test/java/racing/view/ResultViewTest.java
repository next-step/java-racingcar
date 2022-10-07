package racing.view;

import org.junit.jupiter.api.Test;
import racing.core.Car;
import racing.core.ClientInput;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

//    @Test
//    void 생성자를_통한_객체전달(){
//        int carCount = 5;
//        int tryCount = 3;
//        List<Car> carList = makeCarList(carCount);
//        ClientInput racingDto = ClientInput.builder()
//                .tryCount(tryCount)
//                .carCount(carList.size())
//                .build();
//
//        ResultView resultView = ResultView.builder()
//                .carList(carList)
//                .racingDto(racingDto)
//                .build();
//
//        assertThat(resultView.getCarList()).isEqualTo(carList);
//        assertThat(resultView.getRacingDto()).isEqualTo(racingDto);
//    }

    private List<Car> makeCarList(int size) {
        List<Car> carList = new ArrayList<>();
        for(int i = 0; i < size; i++){
            carList.add(new Car());
        }
        return carList;
    }

}
