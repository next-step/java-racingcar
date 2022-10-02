package racing;

import racing.controller.RaceController;
import racing.service.RaceService;

public class Game
{
    public static void main(String[] args)
    {
        RaceController.getInstance(RaceService.getInstance()).run();
    }
}
