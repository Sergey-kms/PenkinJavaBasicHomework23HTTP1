package ru.otus.java.basic.http.server.processors;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import ru.otus.java.basic.http.server.Animal;
import ru.otus.java.basic.http.server.Cat;
import ru.otus.java.basic.http.server.Dog;
import ru.otus.java.basic.http.server.Horse;
import ru.otus.java.basic.http.server.HttpRequest;

public class AnimalRequestProcessor implements RequestProcessor{
    private Gson gson;
    private List<Animal> animal = new ArrayList<>();

    public AnimalRequestProcessor() {
        listFill();
    }

    private void listFill() {
        animal.add(new Cat("Мурзик", "белый"));
        animal.add(new Dog("Дозор", "черный"));
        animal.add(new Horse("Гром", "серый"));
    }

    @Override
    public void execute(HttpRequest httpRequest, OutputStream output) throws IOException {
        gson = new Gson();
        String response = "HTTP/1.1 200 OK\r\nContent-Type: application/json\r\n\r\n" +  gson.toJson(animal);
        System.out.println(gson.toJson(animal));
        output.write(response.getBytes(StandardCharsets.UTF_8));
    }
    
}
