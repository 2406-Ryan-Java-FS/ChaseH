package net.revature.projzero.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

@Entity
@Table(name = "videogames")
@JsonPropertyOrder({"gameId", "gameName", "rating", "genre"})
public class VideoGame {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private int game_id;

    @Column(name = "game_name")
    @JsonProperty("gameName")
    private String gameName;

    @Column(name = "rating")
    @JsonProperty("rating")
    private int rating;

    @Column(name = "genre")
    @JsonProperty("genre")
    private String genre;

    public VideoGame() {
    }

    public VideoGame(int gameId, String gameName, int rating, String genre) {
        this.game_id = gameId;
        this.gameName = gameName;
        this.rating = rating;
        this.genre = genre;
    }



    public int getGameId() {
        return game_id;
    }

    public String getGameName() {
        return gameName;
    }

    public int getRating() {
        return rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGameId(int gameId) {
        this.game_id = gameId;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "game_id=" + game_id +
                ", gameName='" + gameName + '\'' +
                ", rating=" + rating +
                ", genre='" + genre + '\'' +
                '}';
    }
}
