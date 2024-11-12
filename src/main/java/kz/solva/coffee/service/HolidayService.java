package kz.solva.coffee.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import kz.solva.coffee.model.Holiday;

@Service
public interface HolidayService {
    List<Holiday> getHolidaysByYear(int year) throws IOException, InterruptedException;
}
