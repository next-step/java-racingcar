package racing.view;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import racing.core.Car;
import racing.core.RacingDto;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Builder
public class ResultView {
    private final List<Car> carList;
    private final RacingDto racingDto;

    public void print(){
        int tryCount = racingDto.getTryCount();
        for(int i = 0; i < tryCount; i++){
            carList.forEach(car -> {
                car.roll();
                System.out.println(car.go());
            });
            System.out.println();
        }
    }
}
