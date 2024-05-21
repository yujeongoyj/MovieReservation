package controller;




import model.MovieDTO;
import util.ScannerUtil;
import viewer.MovieViewer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieController {
    private ArrayList<MovieDTO> list;
    private int nextId;
    private Scanner scanner;
    private MovieViewer movieViewer;


    public MovieController(){
        list = new ArrayList<>();
        nextId =1;
    }

    public void addMovie(MovieDTO movieDTO) {
        movieDTO.setId(nextId++);
        list.add(movieDTO);
    }

    public List<MovieDTO> selectAll() {
        return list;
    }

    public MovieDTO selectOne(int id) {
        for (MovieDTO movie : list) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

       // 영화 수정
    public void update(MovieDTO updatedMovie) {
        for (int i = 0; i < list.size(); i++) {
            MovieDTO movie = list.get(i);
            if (movie.getId() == updatedMovie.getId()) {
                list.set(i, updatedMovie);
                return;
            }
        }
    }


    // 영화 삭제
    public void delete(int id) {
        MovieDTO temp = new MovieDTO();
        temp.setId(id);
        list.remove(temp);
    }



    public boolean validateInput(int input) {
        if (input == 0) {
            return true;
        }
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(input);
        return list.contains(movieDTO);
    }

}
