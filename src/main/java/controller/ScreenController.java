package controller;

import model.ScreenDTO;
import model.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class ScreenController {
    private ArrayList<ScreenDTO> list;
    private int nextId;

    public ScreenController() {
        list = new ArrayList<>();
        nextId = 1;


        ScreenDTO screen = new ScreenDTO();
        screen.setId(nextId++);
        screen.setMovieId(1);
        screen.setTheaterId(1);
        screen.setScreenTime("14:00");
        list.add(screen);

    }

    public void addScreen(ScreenDTO screenDTO) {
        screenDTO.setId(nextId++);
        list.add(screenDTO);
    }

    public List <ScreenDTO> selectAll() {
        return list;
    }

    public ScreenDTO selectOne(int id) {
        for (ScreenDTO screen : list) {
            if (screen.getId() == id) {
                return screen;
            }
        }
        return null;
    }

    public void update(ScreenDTO updatedScreen) {
        for (int i = 0; i < list.size(); i++) {
            ScreenDTO screen = list.get(i);
            if (screen.getId() == updatedScreen.getId()) {
                list.set(i, updatedScreen);
                return;
            }
        }
    }

    public void delete(int id) {
        ScreenDTO temp = new ScreenDTO();
        temp.setId(id);
        list.remove(temp);
    }


}
