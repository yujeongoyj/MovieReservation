package controller;

import model.MovieDTO;
import model.TheaterDTO;

import java.util.ArrayList;
import java.util.List;

public class TheaterController {
    private ArrayList<TheaterDTO> list;
    private int nextId;

    public TheaterController(){
        list = new ArrayList<>();
        nextId =1;
    }
    public void addTheater(TheaterDTO theaterDTO) {
        theaterDTO.setId(nextId++);
        list.add(theaterDTO);
    }


    public List<TheaterDTO> selectAll() {
        return list;
    }

    public TheaterDTO selectOne(int id) {
        for (TheaterDTO theater : list) {
            if (theater.getId() == id) {
                return theater;
            }
        }
        return null;
    }

    public void update(TheaterDTO updatedTheater) {
        for (int i = 0; i < list.size(); i++) {
            TheaterDTO theater = list.get(i);
            if (theater.getId() == updatedTheater.getId()) {
                list.set(i, updatedTheater);
                return;
            }
        }
    }
    public void delete(int id) {
        TheaterDTO temp = new TheaterDTO();
        temp.setId(id);
        list.remove(temp);
    }
}
