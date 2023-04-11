package carracing.service;

import carracing.domain.Round;
import carracing.domain.Score;
import carracing.repository.RoundRepository;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingService {
    private static final Random random = new Random();
    private final RoundRepository roundRepository;

    public RacingService(RoundRepository roundRepository) {
        this.roundRepository = new RoundRepository();
    }

//    public void racingStart(int participate, int iterations) {
//         IntStream.rangeClosed(1, iterations)
//            .boxed()
//            .collect(
//                Collectors.toMap(Round::new, round -> simulateSingleRoundScores(participate))
//            );
//    }
//
//    public List<Score> simulateSingleRoundScores(int participate) {
//        return IntStream.generate(this::randomScore)
//            .limit(participate)
//            .boxed()
//            .map(Score::new)
//            .collect(Collectors.toList());
//    }

    private int randomScore() {
        return random.nextInt(9);
    }

    public void racingStart(int participates, int iterations) {
        IntStream.rangeClosed(1, iterations)
            .boxed()
            .forEach(integer -> roundStart(participates));
    }

    public List<Round> racingResults() {
        return roundRepository.findAll();
    }

    private void roundStart(int participates) {
        roundRepository.save(
            new Round(
                IntStream.rangeClosed(1, participates)
                    .boxed()
                    .map(s -> randomScore())
                    .map(Score::new)
                    .collect(Collectors.toList())
            )
        );
    }
}
