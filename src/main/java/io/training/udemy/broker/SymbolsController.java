package io.training.udemy.broker;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;

@Controller("/symbols")
public class SymbolsController {

    private final InMemoryStore store;

    public SymbolsController(InMemoryStore store) {
        this.store = store;
    }

    @Get("/hello")
    public String hello() {
        return "hello";
    }

    @Get("/")
    public List<Symbol> getAll() {
        return store.getAll().values().stream().toList();
    }
}
