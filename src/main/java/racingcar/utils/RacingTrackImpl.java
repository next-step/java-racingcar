package racingcar.utils;

public class RacingTrackImpl implements RacingTrack {
    @Override
    public void run(int playCount, Playable playable) {
        for(int i=0; i<playCount; i++){
            playable.run();
        }
    }
}