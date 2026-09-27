package io.github.orberyx.astrowatch.nasa.dto;

import java.util.List;

public class AsteroideDto {

    private String id;
    private String name;
    private String nasa_jpl_url;
    private double absolute_magnitude_h;
    private boolean is_potentially_hazardous_asteroid;
    private boolean is_sentry_object;
    private EstimatedDiameterDto estimated_diameter;
    private List<AproximacaoDto> close_approach_data;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNasa_jpl_url() {
        return nasa_jpl_url;
    }

    public double getAbsolute_magnitude_h() {
        return absolute_magnitude_h;
    }

    public boolean isIs_potentially_hazardous_asteroid() {
        return is_potentially_hazardous_asteroid;
    }

    public boolean isIs_sentry_object() {
        return is_sentry_object;
    }

    public EstimatedDiameterDto getEstimated_diameter() {
        return estimated_diameter;
    }

    public List<AproximacaoDto> getClose_approach_data() {
        return close_approach_data;
    }

    public static class EstimatedDiameterDto {
        private Kilometers kilometers;

        public Kilometers getKilometers() {
            return kilometers;
        }
    }

    public static class Kilometers {
        private double estimated_diameter_min;
        private double estimated_diameter_max;

        public double getEstimated_diameter_min() {
            return estimated_diameter_min;
        }

        public double getEstimated_diameter_max() {
            return estimated_diameter_max;
        }
    }
}