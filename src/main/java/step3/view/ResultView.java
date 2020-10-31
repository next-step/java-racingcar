package step3.view;

import step3.SimulationStep;

import java.io.PrintWriter;
import java.util.List;

public class ResultView {
    private PrintWriter output;

    public ResultView(PrintWriter output) {
        this.output = output;
    }

    public void show(List<SimulationStep> simulationResult) {
        output.println("실행 결과");
        for (int i = 0; i < simulationResult.size(); i++) {
            output.print(simulationResult.get(i).toString());
        }
    }
}
