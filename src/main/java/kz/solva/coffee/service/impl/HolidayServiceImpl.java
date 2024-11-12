package kz.solva.coffee.service.impl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kz.solva.coffee.model.Holiday;
import kz.solva.coffee.service.HolidayService;

@Service
public class HolidayServiceImpl implements HolidayService{

    @Cacheable("holidays")
    @Override
    public List<Holiday> getHolidaysByYear(int year) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest
            .newBuilder()
            .uri(URI.create(("https://date.nager.at/api/v3/publicholidays/").concat(String.valueOf(year)).concat("/kz")))
            .GET()
            .build();

        
        String responseStr = client.send(request, BodyHandlers.ofString()).body();
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        return objectMapper.readValue(responseStr, new TypeReference<List<Holiday>>(){});
    }
}
