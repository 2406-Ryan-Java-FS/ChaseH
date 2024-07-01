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
            if(game.getGameName() == null || game.getRating() == 0 || game.getGenre() == null){
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
    public ResponseEntity<String> deleteGameById(@PathVariable int gameId){
        boolean isSuccessful = this.vgService.deleteGameById(gameId) == 1 ? true : false;

        if(isSuccessful) return ResponseEntity.ok("Entry successfully deleted");
        else return new ResponseEntity<>("Entry could not be deleted", HttpStatusCode.valueOf(400));
    }

    @PatchMapping("videogames/{game_id}")
    public ResponseEntity<String> updateGameById(@PathVariable("game_id") int gameId, @RequestBody UpdateRatingRequest request){

        try{
            int newRating = request.getRating();

            if(newRating > 10 || newRating < 0) return ResponseEntity.badRequest().body("Rating must be between 0 and 10");

            int rowsUpdated = this.vgService.updateGameRatingById(gameId, newRating);

            if(rowsUpdated == 1) return ResponseEntity.ok("Rating successfully updated");
            else return ResponseEntity.badRequest().body("Rating not updated");


        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
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


