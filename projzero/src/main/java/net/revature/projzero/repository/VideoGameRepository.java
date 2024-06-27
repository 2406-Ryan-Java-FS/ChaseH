package net.revature.projzero.repository;

import jakarta.transaction.Transactional;
import net.revature.projzero.model.VideoGame;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideoGameRepository extends CrudRepository<VideoGame, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE VideoGame v SET v.rating = :rating WHERE v.game_id = :gameId")
    int updateMessageTextByMessageId(@Param("rating")int rating, @Param("gameId")int game_id);
}
