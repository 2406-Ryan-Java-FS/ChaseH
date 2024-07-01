package net.revature.projzero;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.revature.projzero.model.VideoGame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.jdbc.Sql;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class AddVideoGameTest {

    ApplicationContext app;
    HttpClient webClient;
    ObjectMapper objMapper;


    @BeforeEach
    public void setup() throws InterruptedException {
        webClient = HttpClient.newHttpClient();
        objMapper = new ObjectMapper();
        String[] args = new String[] {};
        app = SpringApplication.run(ProjzeroApplication.class, args);
        Thread.sleep(500);
    }

    @AfterEach
    public void tearDown() throws InterruptedException{
        Thread.sleep(500);
        SpringApplication.exit(app);
    }



    @Test
    public void createVideoGameTestSuccess() throws IOException, InterruptedException {
        String json = "{\"gameName\":\"Minecraft\",\"rating\":10,\"genre\":\"Sandbox\"}";
        HttpRequest postVideoGameRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/videogames"))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = webClient.send(postVideoGameRequest, HttpResponse.BodyHandlers.ofString());
        int status = response.statusCode();
        Assertions.assertEquals(200, status, "Expected was status code 200; Actual code was: " + status);
        ObjectMapper om = new ObjectMapper();
        String expectedResult = new VideoGame(3, "Minecraft", 10, "Sandbox").toString();
        String actualResult = String.valueOf(om.readValue(response.body().toString(), VideoGame.class));
        Assertions.assertEquals(expectedResult, actualResult, "Expected = " + expectedResult + ", Actual = " + actualResult);
    }

}
