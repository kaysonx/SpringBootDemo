package me.utlight.controller;

import me.utlight.dao.IScoreDao;
import me.utlight.entity.Score;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {

    private static final Logger logger = LoggerFactory.getLogger(ScoreController.class);

    @Autowired
    private IScoreDao scoreService;

    @RequestMapping("/list")
    public List<Score> getScoreList(){
        logger.info("read data from the database by using jpa...");
        logger.info("update lineNumber:" + scoreService.updateScoreById(66.6f,1));

        scoreService.delete(3);

        return scoreService.getList();

    }


}
