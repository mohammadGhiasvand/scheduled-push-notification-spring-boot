package com.noah.push_notification.tasks;

import com.noah.push_notification.requests.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

@Component
public class EasyChallengeLevel {

    @Value("${EASY_SECRET_KEY}")
    private String SECRET_KEY;

    @Value("${CLIENT_URL}")
    private String CLIENT_URL;

    private static final Logger log =
            LoggerFactory.getLogger((EasyChallengeLevel.class));

    @Scheduled(cron = "0 30 7 * * *")
    public void atHalfSeven() {
        httpPostRequestToClientEndPoint();
    }

    @Scheduled(cron = "0 0 12 * * *")
    public void atTwelve() {
        httpPostRequestToClientEndPoint();
    }

    @Scheduled(cron = "0 30 17 * * *")
    public void atHalfSeventeen() {
        httpPostRequestToClientEndPoint();
    }
    @Scheduled(fixedRate = 1000)
    public void x() {
        httpPostRequestToClientEndPoint();
    }

    private void httpPostRequestToClientEndPoint() {
        HashMap<String, String> requestBody = new HashMap<>();
        requestBody.put("challengeId", "EASY");
        requestBody.put("secret", SECRET_KEY);

        Post newPostRequest = new Post(requestBody, CLIENT_URL);
        try {
            newPostRequest.postRequest();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}