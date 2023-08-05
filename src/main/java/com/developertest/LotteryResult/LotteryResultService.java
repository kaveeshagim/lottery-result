package com.developertest.LotteryResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LotteryResultService {

    private final LotteryResultDao lotteryResultDao;

    @Autowired
    public LotteryResultService(LotteryResultDao lotteryResultDao) {
        this.lotteryResultDao = lotteryResultDao;
    }

    public void saveLotteryResult(Date lotteryDate, String results) {
        LotteryResult lotteryResult = new LotteryResult();
        lotteryResult.setLotteryDate(lotteryDate);
        lotteryResult.setResults(results);

        lotteryResultDao.save(lotteryResult);
    }
}

