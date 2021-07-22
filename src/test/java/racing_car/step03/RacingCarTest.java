package racing_car.step03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {
    Random r;
    String[] cars;
    Race race;
    int count = 3;
    int attempt = 5;

    @BeforeEach
    void init() {
        r = new Random();
        cars = new String[3];
        race = new Race();
    }

    @Test
    @DisplayName("난수 생성 테스트")
    public void 난수생성() {
        for (int i = 0; i < 5; i++) {
            int random = r.nextInt(10);
            System.out.print(random + " ");
        }
    }

    @Test
    @DisplayName("random 값이 4이상일 때 전진하는 테스트")
    public void 전진() {
        Random r = new Random();
        int random = r.nextInt(10);
        String car = "";
        if (random >= 4) {
            car += "-";
            assertThat(car).isEqualTo("-");
        } else {
            assertThat(car).isEqualTo("");
        }
    }

    @Test
    @DisplayName("자동차의 상태 배열로 저장")
    public void 자동차의상태() {
        Arrays.fill(cars," ");
        while (attempt-- > 0) {
            String[] result = race.car(count, cars);
            for (String s : result){
                System.out.println(s);
            }
            System.out.println();
        }
    }
}