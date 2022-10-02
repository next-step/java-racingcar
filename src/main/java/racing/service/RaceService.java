package racing.service;

import racing.domain.Cars;
import racing.domain.RaceHistory;
import racing.domain.strategy.RandomMovingStrategy;

import java.util.stream.IntStream;

public class RaceService
{
    private static RaceService raceService;

    public static RaceService getInstance()
    {
        if (raceService == null)
        {
            raceService = new RaceService();
        }
        return raceService;
    }

    public RaceHistory gameStart(String[] writeCarName, int tryNumber)
    {
        RaceHistory raceHistory = new RaceHistory();
        Cars cars = Cars.of(writeCarName, new RandomMovingStrategy());

        IntStream.range(1, tryNumber + 1)
            .forEach(turn -> raceHistory.save(turn, cars.moving()));

        return raceHistory;
    }
}
