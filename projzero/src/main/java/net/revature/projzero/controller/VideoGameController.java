package net.revature.projzero.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.revature.projzero.model.VideoGame;
import net.revature.projzero.repository.VideoGameRepository;
import net.revature.projzero.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VideoGameController {

    @Autowired
    VideoGameService vgService;

    public VideoGameController(VideoGameService vgService) {
        this.vgService = vgService;
    }


    @PostMapping("videogames")
    public ResponseEntity<VideoGame> addVideoGame(@RequestBody VideoGame game){
            if(game.getGameName() == null || (game.getRating() < 0 || game.getRating() > 10) || game.getGenre() == null){
                return ResponseEntity.badRequest().body(null);
            }

            return ResponseEntity.ok(this.vgService.addGame(game));
    }

    @GetMapping("videogames/{gameId}")
    public ResponseEntity<VideoGame> getVideoGameById(@PathVariable int gameId){
        return ResponseEntity.ok(this.vgService.getGameById(gameId));
    }

    @GetMapping("videogames")
    public ResponseEntity<List<VideoGame>> getAllGames(){
        return ResponseEntity.ok(this.vgService.getAllGames());
    }

    @DeleteMapping("videogames/{gameId}")
    public ResponseEntity<Integer> deleteGameById(@PathVariable int gameId){
        boolean isSuccessful = this.vgService.deleteGameById(gameId) == 1 ? true : false;

        if(isSuccessful) return ResponseEntity.ok(1);
        else return ResponseEntity.badRequest().body(0);
    }

    @PatchMapping("videogames/{game_id}")
    public ResponseEntity<Integer> updateGameById(@PathVariable("game_id") int gameId, @RequestBody UpdateRatingRequest request){

        try{
            int newRating = request.getRating();

            if(newRating > 10 || newRating < 0) return ResponseEntity.badRequest().body(0);

            int rowsUpdated = this.vgService.updateGameRatingById(gameId, newRating);

            if(rowsUpdated == 1) return ResponseEntity.ok(1);
            else return ResponseEntity.badRequest().body(0);


        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("accounts/{account_id}")
    public ResponseEntity<List<VideoGame>> getAllGamesForAccount(@PathVariable("account_id") int accountId){
        return ResponseEntity.ok(this.vgService.getAllGamesForAccount(accountId));
    }
}

class UpdateRatingRequest{
    private int rating;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}


