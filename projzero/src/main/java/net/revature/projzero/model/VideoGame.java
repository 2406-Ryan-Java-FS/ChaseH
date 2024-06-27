package net.revature.projzero.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

@Entity
@Table(name = "videogames")
@JsonPropertyOrder({"gameId", "gameName", "rating"})
public class VideoGame {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private int game_id;

    @Column(name = "game_name")
    @JsonProperty("gameName")
    private String game_name;

    @Column(name = "rating")
    @JsonProperty("rating")
    private int rating;

    public VideoGame() {
    }

    public VideoGame(String game_name, int rating) {
        this.game_name = game_name;
        this.rating = rating;
    }
    public VideoGame(int game_id, String game_name, int rating) {
        this.game_id = game_id;
        this.game_name = game_name;
        this.rating = rating;
    }



    public int getGameId() {
        return game_id;
    }

    public String getGameName() {
        return game_name;
    }

    public int getRating() {
        return rating;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
