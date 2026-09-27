package io.github.orberyx.astrowatch.nasa.dto;

public class AproximacaoDto {
    private String close_approach_date;
    private String close_approach_date_full;
    private RelativeVelocity relative_velocity;
    private MissDistance miss_distance;
    private String orbiting_body;

    public String getClose_approach_date() {
        return close_approach_date;
    }

    public String getClose_approach_date_full() {
        return close_approach_date_full;
    }

    public RelativeVelocity getRelative_velocity() {
        return relative_velocity;
    }

    public MissDistance getMiss_distance() {
        return miss_distance;
    }

    public String getOrbiting_body() {
        return orbiting_body;
    }

    public static class RelativeVelocity{
        String kilometers_per_hour;

        public String getKilometers_per_hour() {
            return kilometers_per_hour;
        }
    }

    public static class MissDistance{
        String kilometers;
        String lunar;

        public String getKilometers() {
            return kilometers;
        }

        public String getLunar() {
            return lunar;
        }
    }
}



