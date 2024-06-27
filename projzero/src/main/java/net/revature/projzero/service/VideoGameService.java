package net.revature.projzero.service;

import net.revature.projzero.model.VideoGame;
import net.revature.projzero.repository.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoGameService {

    @Autowired
    VideoGameRepository vgRepo;

    public VideoGameService(VideoGameRepository vgRepo) {
        this.vgRepo = vgRepo;
    }

    public VideoGame addGame(VideoGame game){
        return this.vgRepo.save(game);
    }

    public List<VideoGame> getAllGames(){
        return (List<VideoGame>) this.vgRepo.findAll();
    }

    public VideoGame getGameById(int gameId){
        Optional<VideoGame> optGame = this.vgRepo.findById(gameId);

        if(optGame.isPresent()) return optGame.get();
        else return null;
    }

    public int deleteGameById(int gameID){
        try{
            this.vgRepo.deleteById(gameID);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    public int updateGameRatingById(int gameId, int rating){
        return this.vgRepo.updateMessageTextByMessageId(rating, gameId);
    }
}
