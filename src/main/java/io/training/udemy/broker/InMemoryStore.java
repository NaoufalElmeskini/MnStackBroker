package io.training.udemy.broker;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

@Singleton
public class InMemoryStore {
    private final Logger LOG = LoggerFactory.getLogger(InMemoryStore.class);
    private final Map<String, Symbol> symbols = new HashMap<>();
    private final Faker faker = new Faker();

    @PostConstruct
    private void init() {
        IntStream.range(1, 10).forEach(i -> addSymbol());
    }

    public void addSymbol() {
        Symbol symbol = new Symbol(faker.stock().nsdqSymbol());
        symbols.put(symbol.value(), symbol);
        LOG.info("adding symbol : {}", symbol);
    }


    public Map<String, Symbol> getAll () {
        return symbols;
    }
}
