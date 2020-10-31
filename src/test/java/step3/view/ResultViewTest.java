package step3.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.SimulationStep;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("게임 결과 출력 테스트")
public class ResultViewTest {

    @DisplayName("여러 스텝의 자동차 상태 출력")
    @Test
    public void getSimulationStepSnapshot() {
        List<SimulationStep> steps = new ArrayList<>();
        steps.add(getSimulationStep(Arrays.asList(1, 1, 1)));
        steps.add(getSimulationStep(Arrays.asList(2, 1, 2)));
        steps.add(getSimulationStep(Arrays.asList(3, 2, 3)));
        steps.add(getSimulationStep(Arrays.asList(4, 3, 4)));
        steps.add(getSimulationStep(Arrays.asList(4, 4, 5)));

        StringWriter output = new StringWriter();
        ResultView resultView = new ResultView(new PrintWriter(output));
        resultView.show(steps.stream().map(SimulationStep::toString).collect(Collectors.toList()));

        assertThat(output.toString()).isEqualTo("실행 결과\n" +
                "-\n" +
                "-\n" +
                "-\n" +
                "\n" +
                "--\n" +
                "-\n" +
                "--\n" +
                "\n" +
                "---\n" +
                "--\n" +
                "---\n" +
                "\n" +
                "----\n" +
                "---\n" +
                "----\n" +
                "\n" +
                "----\n" +
                "----\n" +
                "-----\n\n");
    }

    private SimulationStep getSimulationStep(List<Integer> positions) {
        List<Car> cars = new ArrayList();
        for (int i = 0; i < positions.size(); i++) {
            cars.add(getCarWithPosition(positions.get(i)));
        }
        SimulationStep step = new SimulationStep(cars);
        return step;
    }

    private Car getCarWithPosition(int expectedPosition) {
        Car car = new Car();
        for (int i = 0; i < expectedPosition; i++) {
            car.move(9);
        }
        return car;
    }
}