package racing.winner.resolver;

import racing.winner.resolver.CarDto.Response;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

public class OutputViewResolver {

    private static final int ZERO = 0;
    private static final PrintStream PRINT_STREAM = System.out;

    private static final String LINE_SYMBOL = "-";

    public void displayWinners(List<Response.CarInformation> winners) {
        List<String> winnerNames = winners.stream()
                .map(Response.CarInformation::getName)
                .collect(Collectors.toList());
        String winnersToPlainText = String.join(",", winnerNames);
        PRINT_STREAM.println(winnersToPlainText + " 가 최종 우승했습니다.");
    }

    public void displayTracks(List<Response.CarInformation> carInformations) {
        for (Response.CarInformation carInformation : carInformations) {
            PRINT_STREAM.println(displayOneTrack(carInformation));
        }
        PRINT_STREAM.println();
    }

    private String displayOneTrack(Response.CarInformation carInformation) {
        String name = carInformation.getName();
        int count = carInformation.getDistanceDriven();

        return name + " : " + displayLine(count);
    }

    private String displayLine(int lineLength) {
        StringBuilder line = new StringBuilder();
        for (int i = ZERO; i < lineLength; i++) {
            line.append(LINE_SYMBOL);
        }
        return line.toString();
    }
}
