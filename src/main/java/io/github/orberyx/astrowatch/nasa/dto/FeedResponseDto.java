package io.github.orberyx.astrowatch.nasa.dto;
import com.google.gson.annotations.SerializedName;
import java.util.List;

import java.util.Map;

public class FeedResponseDto {
    @SerializedName("near_earth_objects")
    private Map<String, List<AsteroideDto>> asteroidesPorData;

    public Map<String, List<AsteroideDto>> getAsteroidesPorData() {
        return asteroidesPorData;
    }
}
