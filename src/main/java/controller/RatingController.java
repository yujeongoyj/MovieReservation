package controller;

import model.RatingDTO;

import java.util.ArrayList;

public class RatingController {
    private ArrayList<RatingDTO> list;
    private int nextId;

    public RatingController() {
        list = new ArrayList<>();
        nextId = 1;
    }

    public void addRating(RatingDTO ratingDTO) {
        ratingDTO.setId(nextId++);
        list.add(ratingDTO);
    }


}
