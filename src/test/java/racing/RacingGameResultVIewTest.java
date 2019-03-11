package racing;

import org.junit.Test;

public class RacingGameResultVIewTest {
    @Test
    public void 출력테스트()
    {
        RacingGame rg = new RacingGame();
        rg.initRacingGame(5,2);
        GameRule gr = new GameRule(false);
        rg.runRacingGame(gr);

        for(int i = 0; i < rg.getTime(); i++)
        {
            for(int j = 0; j < rg.getList().size(); j++)
            {
                String outputValue = "";
                for(int k = 0; k < rg.getList().get(j).getMoveValues().get(i); k++)
                {
                    outputValue += "-";
                }

                System.out.println(outputValue);
            }
            System.out.println();
        }
    }
}