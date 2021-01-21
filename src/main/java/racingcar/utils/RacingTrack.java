package racingcar.utils;

public interface RacingTrack {
    void run(int playCount, Playable playable);

    interface Playable {
        void run();
    }
}