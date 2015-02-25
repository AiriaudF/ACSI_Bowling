package controllers;


import models.Game;
import models.Player;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

    public static Result index() {

        Player p1 = new Player(1,"p1");
        Game game = new Game(1);
        game.addPlayer(p1);
        try {
            while(p1.getCurrentScoreboard().getTurnRemaining()>=0){
                p1.shot();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok(index.render(game));
    }

}
