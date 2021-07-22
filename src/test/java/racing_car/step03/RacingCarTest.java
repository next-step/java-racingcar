package racing_car.step03;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

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
            int random = race.getRandomNumber();
            System.out.print(random + " ");
        }
    }

    @ParameterizedTest
    @DisplayName("random 값이 4이상일 때 전진하는 테스트")
    @CsvSource(value = {"3:false","4:true","2:false","6:true","1:false"},delimiter = ':')
    public void 전진(int number , boolean move) {
        Assertions.assertThat(race.move(number)).isEqualTo(move);
    }

    @Test
    @DisplayName("자동차의 상태 배열로 저장")
    public void 자동차의상태() {
//        Arrays.fill(cars," ");
//        while (attempt-- > 0) {
//            String[] result = race.execute(count, );
//            for (String s : result){
//                System.out.println(s);
//            }
//            System.out.println();
//        }
    }
}