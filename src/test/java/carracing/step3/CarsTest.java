package carracing.step3;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @ParameterizedTest(name = "자동차 움직임 테스트 : 입력 1, ()->9 : 결과 -\n")
    @ArgumentsSource(CarsArgumentsProviderOver4.class)
    void moveAllCarsRandomly(int carCount, Supplier<Integer> generateNine) {
        Cars cars = new Cars(carCount, generateNine);
        cars.moveAllCars();
        assertThat(cars.getAllCarsTrace()).isEqualTo("-\n");
    }

    @ParameterizedTest(name = "자동차 움직임 테스트 : 입력 1, ()->1 : 결과 \n")
    @ArgumentsSource(CarsArgumentsProviderBelow4.class)
    void moveAllCarsRandomly2(int carCount, Supplier<Integer> generateNine) {
        Cars cars = new Cars(carCount, generateNine);
        cars.moveAllCars();
        assertThat(cars.getAllCarsTrace()).isEqualTo("\n");
    }

    @ParameterizedTest(name = "자동차 움직임 흔적 테스트 : 입력 1, ()->9 : 결과 -\n")
    @ArgumentsSource(CarsArgumentsProviderOver4.class)
    void getAllCarsTrace(int carCount, Supplier<Integer> generateNine) {
        Cars cars = new Cars(carCount, generateNine);
        cars.moveAllCars();
        assertThat(cars.getAllCarsTrace()).isEqualTo("-\n");
    }

    @ParameterizedTest(name = "자동차 움직임 흔적 테스트 : 입력 1, ()->1 : 결과 \n")
    @ArgumentsSource(CarsArgumentsProviderBelow4.class)
    void getAllCarsTrace2(int carCount, Supplier<Integer> generateNine) {
        Cars cars = new Cars(carCount, generateNine);
        cars.moveAllCars();
        assertThat(cars.getAllCarsTrace()).isEqualTo("\n");
    }


    static class CarsArgumentsProviderOver4 implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(1, numberGenerator())
            );
        }

        private Supplier<Integer> numberGenerator() {
            return () -> 9;
        }
    }

    static class CarsArgumentsProviderBelow4 implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(1, numberGenerator())
            );
        }

        private Supplier<Integer> numberGenerator() {
            return () -> 1;
        }
    }
}