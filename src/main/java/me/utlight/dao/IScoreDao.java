package me.utlight.dao;

import me.utlight.entity.Score;
import me.utlight.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IScoreDao extends CrudRepository<Score, Integer>{

    @Transactional
    @Modifying
    @Query("update Score s set s.score = :score where s.id = :id")
    int updateScoreById(@Param("score")float score, @Param("id")int id);

    @Query("SELECT s FROM Score s")
    List<Score> getList();
}
