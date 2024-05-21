package controller;




import model.MovieDTO;

import java.util.ArrayList;
import java.util.List;

public class MovieController {
    private ArrayList<MovieDTO> list;
    private int nextId;

    public MovieController(){
        list = new ArrayList<>();
        nextId =1;
    }

    public void addMovie(MovieDTO movieDTO) {
        movieDTO.setId(nextId++);
        list.add(movieDTO);
    }

//    public List<MovieDTO> selectAll() {
//        return new ArrayList<>(list);
//    }
//
//    // ID로 영화 검색
//    public MovieDTO selectOne(int id) {
//        for (MovieDTO movie : list) {
//            if (movie.getId() == id) {
//                return movie;
//            }
//        }
//        return null;
//    }
//
//    // 영화 수정
//    public void update(MovieDTO updatedMovie) {
//        for (int i = 0; i < list.size(); i++) {
//            MovieDTO movie = list.get(i);
//            if (movie.getId() == updatedMovie.getId()) {
//                list.set(i, updatedMovie);
//                return;
//            }
//        }
//    }
//
//    // 영화 삭제
//    public void delete(int id) {
//        list.removeIf(movie -> movie.getId() == id);
//    }

}
