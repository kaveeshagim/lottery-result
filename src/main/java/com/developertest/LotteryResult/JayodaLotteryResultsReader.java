package com.developertest.LotteryResult;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JayodaLotteryResultsReader {

    private final LotteryResultService lotteryResultService;

    @Autowired
    public JayodaLotteryResultsReader(LotteryResultService lotteryResultService) {
        this.lotteryResultService = lotteryResultService;
    }

    public void fetchAndSaveResults() {
        try {
            String websiteURL = "https://lankaresults.com/lottery-results/jayoda/1938";
            Document document = Jsoup.connect(websiteURL).get();
            Elements resultElements = document.select("div.text-center");

            for (Element element : resultElements) {
                String result = element.text();
                String[] resultArray = result.split(" ");
                if (resultArray.length >= 5) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < resultArray.length; i++) {
                        stringBuilder.append(resultArray[i]);
                        stringBuilder.append(" ");
                    }
                    String concatenatedResults = stringBuilder.toString().trim();
                    Date lotteryDate = new Date(); // Set the date as required

                    lotteryResultService.saveLotteryResult(lotteryDate, concatenatedResults);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
