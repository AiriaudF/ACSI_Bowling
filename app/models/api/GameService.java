package models.api;

import models.Game;
import play.libs.Json;

import java.io.IOException;

/**
 * Created by Thomas on 27/04/2015.
 */
public class GameService extends ApiService{
    private static GameService instance;

    public static GameService get(){
        if(instance.equals(null)){
            instance = new GameService();
        }
        return instance;
    }

    public Game load(int id){
        return Json.fromJson(get("/game/" + id),Game.class);
    }

    public void update(Game game){
        try {
            put("/game", Json.toJson(game));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void create(Game game){
        try {
            post("/game", Json.toJson(game));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
