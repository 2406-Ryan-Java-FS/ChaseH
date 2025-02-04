package net.revature.projzero;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DeleteVideoGameByIdTest {

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
    public void deleteGameByIdSuccessful() throws IOException, InterruptedException {
        HttpRequest postVideoGameRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/videogames/1"))
                .DELETE()
                .build();
        HttpResponse<String> response = webClient.send(postVideoGameRequest, HttpResponse.BodyHandlers.ofString());
        int status = response.statusCode();
        Assertions.assertEquals(200, status, "Expected was status code 200; Actual code was: " + status);

        Integer actual = objMapper.readValue(response.body().toString(), Integer.class);
        Assertions.assertTrue(actual.equals(1), "Expected to modify 1 row. " + actual + " rows updated");
    }
}
