package viewer;

import controller.MovieController;
import lombok.Setter;
import model.MovieDTO;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieViewer {
    //private ArrayList<MovieDTO> list;

    @Setter
    MovieDTO movieDTO;
    @Setter
    MovieController movieController;
    @Setter
    Scanner scanner;
    @Setter
    BoardViewer boardViewer;


    public void addMovie() {

        MovieDTO movieDTO = new MovieDTO();

        String message = "영화 제목을 입력하세요:";
        movieDTO.setTitle(ScannerUtil.nextLine(scanner, message));

        message = "영화 줄거리를 입력하세요:";
        movieDTO.setContent(ScannerUtil.nextLine(scanner, message));

        message = "영화 등급을 입력하세요:";
        movieDTO.setLevel(ScannerUtil.nextInt(scanner, message));

        movieController.addMovie(movieDTO);
        System.out.println("영화가 성공적으로 등록되었습니다.");
    }

    public void modifyMovie() {
        System.out.println("영화 리스트----------------------");
        movieList();

        String message = "상세보기할 영화 번호를 선택하세요 / 0으로 뒤로가기 ";
        int choice = ScannerUtil.nextInt(scanner, message);
        printOne(choice);

    }

    public void movieList() {
        ArrayList<MovieDTO> list = (ArrayList<MovieDTO>) movieController.selectAll();
        for (MovieDTO m : list) {
            System.out.printf("%d. %s (%d세)\n", m.getId(), m.getTitle(), m.getLevel());
        }


    }


    public void printOne(int id) {
        MovieDTO movieDTO = movieController.selectOne(id);
        System.out.println("찾은 영화: " + movieDTO); // 로그 추가
        if (movieDTO == null) {
            System.out.println("해당 ID의 영화를 찾을 수 없습니다.");
            return;
        }

        System.out.println("==============================");
        System.out.println(movieDTO.getId() + "번");
        System.out.println("제목 : " + movieDTO.getTitle());
        System.out.println("줄거리: " + movieDTO.getContent());
        System.out.println("상영등급 : " + movieDTO.getLevel());
        System.out.println("--------------------------------");
        if (movieDTO.getId() == movieDTO.getId()) {
            String message = "1. 수정 2. 삭제 3. 뒤로가기";
            int choice = ScannerUtil.nextInt(scanner, message);
            if (choice == 1) {
                update(movieDTO);
            } else if (choice == 2) {
                delete(id);
            } else if (choice == 3) {
                modifyMovie();
            }
        }
    }

    // 영화 수정
    public void update(MovieDTO movieDTO) {
        String message = "수정된 제목을 입력해주세요";
        String newTitle = ScannerUtil.nextLine(scanner, message);
        movieDTO.setTitle(newTitle);

        message = "수정된 줄거리를 입력해주세요";
        String newContent = ScannerUtil.nextLine(scanner, message);
        movieDTO.setContent(newContent);

        message = "수정된 등급을 입력해주세요";
        int newLevel = ScannerUtil.nextInt(scanner, message);
        movieDTO.setLevel(newLevel);

        movieController.update(movieDTO);
    }

    public void delete(int id) {
        String message = "정말 삭제하시겠습니까? Y/N";
        String confirm = ScannerUtil.nextLine(scanner, message);
        if(confirm.equalsIgnoreCase("Y") ){
            movieController.delete(id);
            System.out.println("삭제되었습니다");
            movieList();

        }else {
            printOne(id);
        }
    }

    public void userPrintOne(int id) {
        MovieDTO movieDTO = movieController.selectOne(id);
        System.out.println("찾은 영화: " + movieDTO); // 로그 추가
        if (movieDTO == null) {
            System.out.println("해당 ID의 영화를 찾을 수 없습니다.");
            return;
        }

        System.out.println("==============================");
        System.out.println(movieDTO.getId() + "번");
        System.out.println("제목 : " + movieDTO.getTitle());
        System.out.println("줄거리: " + movieDTO.getContent());
        System.out.println("상영등급 : " + movieDTO.getLevel());
        System.out.println("--------------------------------");

    }

}



