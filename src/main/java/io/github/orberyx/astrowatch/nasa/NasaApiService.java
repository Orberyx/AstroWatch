package io.github.orberyx.astrowatch.nasa;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import io.github.orberyx.astrowatch.model.Asteroide;
import io.github.orberyx.astrowatch.nasa.dto.AsteroideDto;
import io.github.orberyx.astrowatch.nasa.dto.FeedResponseDto;
import io.github.orberyx.astrowatch.nasa.mapper.AsteroideMapper;

public class NasaApiService {
    private static final String BASE_URL = "https://api.nasa.gov/neo/rest/v1/feed";
    private final String apiKey;
    private final AsteroideMapper mapper;

    public NasaApiService(String apiKey, AsteroideMapper mapper) {
        this.apiKey = apiKey;
        this.mapper = mapper;
    }

    private String buildUrl(LocalDate inicio, LocalDate fim) {
        return BASE_URL
                + "?start_date=" + inicio
                + "&end_date=" + fim
                + "&detailed=false"
                + "&api_key=" + apiKey;
    }

    public List<Asteroide> buscarAsteroides(LocalDate inicio, LocalDate fim) {
        String url = buildUrl(inicio, fim);
        FeedResponseDto feed = chamarApi(url);

        List<Asteroide> asteroides = new ArrayList<>();

        for (List<AsteroideDto> dtoList : feed.getAsteroidesPorData().values()) {
            for (AsteroideDto dto : dtoList) {asteroides.add(mapper.toAsteroide(dto));}
        }

        return asteroides;
    }

    private FeedResponseDto chamarApi(String url){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET().build();

        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers
                            .ofString());
            String jsonString = response.body();
            Gson gson = new Gson();
            return gson.fromJson(jsonString, FeedResponseDto.class);
        }
        catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

