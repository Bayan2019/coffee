package kz.solva.coffee.service.impl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public List<Holiday> getHolidaysByYear(String year) {

        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest
            .newBuilder()
            .uri(URI.create(("https://date.nager.at/api/v3/publicholidays/").concat(year).concat("/kz")))
            .GET()
            .build();

        
        String responseStr;
        try {
            responseStr = client.send(request, BodyHandlers.ofString()).body();
            ObjectMapper objectMapper = new ObjectMapper();
        
            return objectMapper.readValue(responseStr, new TypeReference<List<Holiday>>(){});
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    // @Cacheable("isholidays")
    @Override
    public Boolean isTodayHoliday() {
        Date currentDate = new Date();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(currentDate);
        return isDateHoliday(date);
    }

    @Override
    public Boolean isNotTodayHoliday() {
        return !isTodayHoliday();
    }

    @Cacheable("isdateholidays")
    @Override
    public Boolean isDateHoliday(String date) {
        List<Holiday> holidays = getHolidaysByYear(date.substring(0, 4));
        for (Holiday h: holidays) {
            if (h.date().equals(date)) {
                return true;
            }
        }
        return false;
    }
}
