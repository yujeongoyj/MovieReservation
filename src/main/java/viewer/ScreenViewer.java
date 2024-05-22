package viewer;

import controller.MovieController;
import controller.ScreenController;
import controller.TheaterController;
import lombok.Setter;
import model.MovieDTO;
import model.ScreenDTO;
import model.TheaterDTO;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class ScreenViewer {


    @Setter
    private ScreenController screenController;
    @Setter
    private MovieController movieController;
    @Setter
    private TheaterController theaterController;
    @Setter
    private Scanner scanner = new Scanner(System.in);
    @Setter
    private MovieViewer movieViewer;
    @Setter
    private TheaterViewer theaterViewer;


    public ScreenViewer() {

    }


    public void addScreen() {
        ScreenDTO screenDTO = new ScreenDTO();

        System.out.println("영화 목록---------------------------");
        movieViewer.movieList();
        String message = "등록할 영화 ID를 입력하세요:";
        int movieId = ScannerUtil.nextInt(scanner, message);
        MovieDTO movie = movieController.selectOne(movieId);
        if (movie == null) {
            System.out.println("해당 ID의 영화를 찾을 수 없습니다.");
            return;
        }
        screenDTO.setMovieId(movieId);

        System.out.println("극장 목록------------------------------");
        theaterViewer.theaterList();
        message = "등록할 극장 ID를 입력하세요:";
        int theaterId = ScannerUtil.nextInt(scanner, message);
        TheaterDTO theater = theaterController.selectOne(theaterId);
        if (theater == null) {
            System.out.println("해당 ID의 극장을 찾을 수 없습니다.");
            return;
        }
        screenDTO.setTheaterId(theaterId);

        message = "상영 시간을 입력하세요 :";
        screenDTO.setScreenTime(ScannerUtil.nextLine(scanner, message));

        screenController.addScreen(screenDTO);
        System.out.println("새로운 상영 정보가 추가되었습니다.");
    }

    public void modifyScreen() {
        System.out.println("상영 정보 리스트-----------------------");
        screenList();
    }

    public void screenList() {
        ArrayList<ScreenDTO> list = (ArrayList<ScreenDTO>) screenController.selectAll();
        for (ScreenDTO s : list) {
            MovieDTO movie = movieController.selectOne(s.getMovieId());
            TheaterDTO theater = theaterController.selectOne(s.getTheaterId());

            System.out.printf("ID: %d. 영화: %s, 극장: %s, 상영 시간: %s\n", s.getId(), movie.getTitle(), theater.getName(), s.getScreenTime());

        }

        String message = "상세보기할 상영 정보 번호를 선택하세요 / 0으로 뒤로가기 ";
        int choice = ScannerUtil.nextInt(scanner, message);
        if (choice != 0) {
            printOne(choice);
        }
    }

    private void printOne(int id) {
        ScreenDTO screenDTO = screenController.selectOne(id);
        if (screenDTO == null) {
            System.out.println("해당 ID의 상영 정보를 찾을 수 없습니다.");
            return;
        }

        MovieDTO movie = movieController.selectOne(screenDTO.getMovieId());
        TheaterDTO theater = theaterController.selectOne(screenDTO.getTheaterId());

        System.out.println("==============================");
        System.out.println("ID: " + screenDTO.getId());
        System.out.println("영화: " + (movie != null ? movie.getTitle() : "알 수 없음"));
        System.out.println("극장: " + (theater != null ? theater.getName() : "알 수 없음"));
        System.out.println("상영 시간: " + screenDTO.getScreenTime());
        System.out.println("--------------------------------");

        String message = "1. 수정 2. 삭제 3. 뒤로가기";
        int choice = ScannerUtil.nextInt(scanner, message);
        if (choice == 1) {
            update(screenDTO);
        } else if (choice == 2) {
            delete(id);
        } else if (choice == 3) {
            modifyScreen();
        }
    }

    public void update(ScreenDTO screenDTO) {
        String message = "수정된 상영 시간을 입력하세요 :";
        screenDTO.setScreenTime(ScannerUtil.nextLine(scanner, message));

        screenController.update(screenDTO);
    }

    public void delete(int id) {
        String message = "정말 삭제하시겠습니까? Y/N";
        String confirm = ScannerUtil.nextLine(scanner, message);
        if (confirm.equalsIgnoreCase("Y")) {
            screenController.delete(id);
            System.out.println("삭제되었습니다");
            screenList();
        } else {
            printOne(id);
        }
    }
}
