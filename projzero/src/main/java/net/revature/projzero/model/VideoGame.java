package net.revature.projzero.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

@Entity
@Table(name = "videogames")
@JsonPropertyOrder({"gameId", "gameName", "rating", "genre", "accountId"})
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

    @Column(name = "account_id")
    @JsonProperty("accountId")
    private int accountId;

    public VideoGame() {
    }

    public VideoGame(int game_id, String gameName, int rating, String genre, int accountId) {
        this.game_id = game_id;
        this.gameName = gameName;
        this.rating = rating;
        this.genre = genre;
        this.accountId = accountId;
    }

    public int getGame_id() {
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

    public int getAccountId() {
        return accountId;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
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

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "game_id=" + game_id +
                ", gameName='" + gameName + '\'' +
                ", rating=" + rating +
                ", genre='" + genre + '\'' +
                ", accountId=" + accountId +
                '}';
    }
}
