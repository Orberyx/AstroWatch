package io.github.orberyx.astrowatch.nasa;

import java.time.LocalDate;

public class NasaApiClient {

    private static final String BASE_URL =
            "https://api.nasa.gov/neo/rest/v1/feed";

    private static final String API_KEY =
            "DEMO_KEY";

    public String buildUrl(LocalDate dateInitial, LocalDate dateFinal) {

        String url = BASE_URL
                + "?start_date=" + dateInitial
                + "&end_date=" + dateFinal
                + "&api_key=" + API_KEY;

        return url;
    }
}