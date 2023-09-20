package io.training.udemy.broker;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.json.tree.JsonNode;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class SymbolsControllerTest {


    @Inject
    @Client("/symbols")
    private HttpClient client;

    @Test
    public void doitRetournerMessageDeBienvenue() {
        //given

        //when
        var response = client.toBlocking().exchange("/hello", String.class);

        //then
        assertEquals(HttpStatus.OK, response.status());
        assertEquals("hello", response.getBody().get());
    }

    @Test
    public void doitRetournerListeDeTousLesSymboles() {
        //given

        //when
        HttpResponse<JsonNode> response = client.toBlocking().exchange("/", JsonNode.class);

        //then
        assertEquals(HttpStatus.OK, response.status());
        assertTrue(response.getBody().isPresent());
        assertEquals(9, response.getBody().get().size());
    }
}
