package nextstep.javaracingcar.view;

import nextstep.javaracingcar.CarDashboard;

import java.util.List;

public class ResultView {
    private final OutputConsumer outputConsumer;

    public ResultView(OutputConsumer outputConsumer) {
        this.outputConsumer = outputConsumer;
    }

    public void printReusltTitle() {
        printEmptyLine();
        this.outputConsumer.write("실행 결과");
    }

    public void printResult(final List<CarDashboard> dashboards) {
        for (CarDashboard dashboard : dashboards) {
            final StringBuffer sb = new StringBuffer("-");
            dashboard.distance().forEach(i -> sb.append("-"));
            outputConsumer.write(sb.toString());
        }
        printEmptyLine();
    }

    private void printEmptyLine() {
        outputConsumer.write("");
    }
}
