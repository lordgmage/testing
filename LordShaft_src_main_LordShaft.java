package main;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import strategies.BankingShaft;
import strategies.ChopAndCut;
import strategies.Shafting;
import view.UI;


import java.util.ArrayList;

@ScriptManifest(author = "Lord",
        category = Category.FLETCHING,
        description = "Makes Arrow shaft",
        name = "LordShaft",
        servers = { "Ikov" },
        version = 2.0)

public class LordShaft extends org.parabot.environment.scripts.Script {

    private static ArrayList<Strategy> strategies = new ArrayList<Strategy>();
    public static boolean bank;
    public static boolean start;

    public boolean onExecute() {
        new UI();
        while (!start) {
            Time.sleep(500);
        }
        strategies.add(new Shafting());
        if (!bank) {
            strategies.add(new ChopAndCut());
        }
            else{strategies.add(new BankingShaft());
        }
        provide(strategies);
        return true;
    }

}
