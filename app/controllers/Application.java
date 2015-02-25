package controllers;


import models.Game;
import models.Player;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

    public static Result index() {

        Player p1 = new Player(1,"Thomas");
        Player p2 = new Player(2,"Aurélien");

        Game game = new Game(1);
        game.addPlayer(p1);
        game.addPlayer(p2);

        for(Player p : game.getPlayers()) {
            try {
                while (p.getCurrentScoreboard().getTurnRemaining() >= 0) {
                    p.shot();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ok(index.render(game));
    }

}
