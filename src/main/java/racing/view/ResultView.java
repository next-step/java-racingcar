package racing.view;

import racing.domain.RaceHistory;
import racing.domain.Record;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView
{
    private ResultView() {}

    private static final String SKID_MARK = "-";
    private static final StringBuilder BUILDER = new StringBuilder();


    public static void draw(RaceHistory raceHistory)
    {
        System.out.println("실행 결과");
        IntStream.range(1, raceHistory.getLastTurn() + 1)
                .mapToObj(raceHistory::getHistoryByTurn)
                .forEach(ResultView::turnDraw);
    }

    public static void winnerDraw(RaceHistory history)
    {
        System.out.println(history.getWinner() + "가 최종 우승했습니다.");
    }


    private static void turnDraw(List<Record> records)
    {
        for (Record record : records)
        {
            appendSkidMark(record);
            System.out.printf("%s : %s%n", record.getCarName(), BUILDER);
        }
        System.out.println();
    }

    private static void appendSkidMark(Record record)
    {
        builderClear();
        IntStream.range(0, record.getPosition())
            .forEach(value -> BUILDER.append(SKID_MARK));
    }

    private static void builderClear()
    {
        BUILDER.delete(0, BUILDER.length());
    }
}
