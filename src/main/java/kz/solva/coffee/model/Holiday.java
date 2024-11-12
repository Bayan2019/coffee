package kz.solva.coffee.model;

import java.util.List;

public record Holiday(String date, String localName, String name, String countryCode, 
    boolean fixed, boolean global, 
    List<String> counties, int launchYear, List<String> types) {
}
