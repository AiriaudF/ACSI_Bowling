package models;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Thomas on 24/02/2015.
 */
public class Game {
    private int id;
    private Date date;
    private ArrayList<Player> players;

    public Game(int id) {
        this.id = id;
        this.date = new Date();
        this.players = new ArrayList<>();
    }

    public Game(int id, ArrayList<Player> players) {
        this.id = id;
        this.date = new Date();
        this.players = players;
        for (Player p : players){
            p.setCurrentGame(this);
            p.newScore(this);
        }
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Game addPlayer(Player p){
        players.add(p);
        p.newScore(this);
        p.setCurrentGame(this);
        return this;
    }

    public Player getNextPlayer(){
        return null;
    }

    public int getWinner() throws Exception {
        int bestScore = 0;
        for (Player p : players){
            if(p.getCurrentScoreboard().getTurns().get(9).getTotalScore()>bestScore){
                bestScore=p.getCurrentScoreboard().getTurns().get(9).getTotalScore();
            }
        }
        return bestScore;
    }

}
