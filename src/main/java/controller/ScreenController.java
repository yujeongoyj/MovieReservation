package controller;

import model.ScreenDTO;

import java.util.ArrayList;
import java.util.List;

public class ScreenController {
    private ArrayList<ScreenDTO> list;
    private int nextId;

    public ScreenController() {
        list = new ArrayList<>();
        nextId = 1;
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
