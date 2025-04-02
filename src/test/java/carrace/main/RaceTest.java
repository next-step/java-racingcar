package carrace.app;

public class RaceTest {

    //    @DisplayName("자동차 대수가 0 이하의 값이면, 에러가 발생합니다.")
    //    @Test
    //    public void updateCurrentStateTest_Negative() {
    //        int negativeNumCar = -1;
    //        Vehicle[] emptyCars = {};
    //        assertThatThrownBy(() -> Race.updateCurrentState(emptyCars, negativeNumCar))
    //                .isInstanceOf(RuntimeException.class);
    //    }

    //    @DisplayName("초기 상태는 무조건 한칸(-)씩 있어야합니다. ")
    //    @Test
    //    public void updateCurrentStateTest() {
    //        int positiveNumCar = 3;
    //        Vehicle[] cars = new Vehicle[positiveNumCar];
    //        Race.prepare(cars, positiveNumCar);
    //        Arrays.stream(cars)
    //                .map(Vehicle::getCurrentPosition)
    //                .forEach(
    //                        position -> {
    //                            assertThat(position).isEqualTo("-");
    //                        });
    //    }
}
