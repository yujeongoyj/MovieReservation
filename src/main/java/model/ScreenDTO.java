package model;

import lombok.Data;


@Data
public class ScreenDTO {
    private int id;
    private int movieId;
    private int theaterId;
    private String screenTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof ScreenDTO) {
            ScreenDTO s = (ScreenDTO) o;
            return id == s.id;
        }

        return false;
    }


}
