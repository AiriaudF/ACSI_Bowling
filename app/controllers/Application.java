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
        Player p3 = new Player(3,"Benjamin");

        Game game = new Game(1);
        game.addPlayer(p1);
        game.addPlayer(p2);
        game.addPlayer(p3);

        while(game.hasNextPlayer()){
            game.getNextPlayer().shot();
        }
        return ok(index.render(game));
    }

}
