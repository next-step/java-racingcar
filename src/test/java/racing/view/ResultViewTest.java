package racing.view;

import org.junit.jupiter.api.Test;
import racing.core.Car;
import racing.core.RacingDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    @Test
    void 생성자를_통한_객체전달(){
        int carCount = 5;
        int tryCount = 3;
        List<Car> carList = Car.makeCarList(carCount);
        RacingDto racingDto = RacingDto.builder()
                .tryCount(tryCount)
                .carCount(carList.size())
                .build();

        ResultView resultView = ResultView.builder()
                .carList(carList)
                .racingDto(racingDto)
                .build();

        assertThat(resultView.getCarList()).isEqualTo(carList);
        assertThat(resultView.getRacingDto()).isEqualTo(racingDto);
    }

}
