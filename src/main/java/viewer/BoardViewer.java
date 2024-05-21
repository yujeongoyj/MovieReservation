package viewer;

import controller.BoardController;
import controller.MovieController;
import controller.UserController;
import lombok.Getter;
import lombok.Setter;
import model.BoardDTO;
import model.MovieDTO;
import model.UserDTO;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardViewer {
    @Setter
    private BoardController boardController;
    @Setter
    private UserController userController;
    @Setter
    private Scanner scanner;
    @Setter
    private UserDTO logIn;
    @Setter
    private UserViewer userViewer;
    @Setter
    private MovieController movieController;
    @Setter
    private MovieDTO movieDTO;




    public void showCriticMenu() {
        System.out.println("-------평론가 화면-----------");
    }


    public void insert() { // 영화 등록하기
        MovieDTO movieDTO = new MovieDTO();


        String message = "영화 제목을 입력하세요:";
        movieDTO.setTitle(ScannerUtil.nextLine(scanner, message));

        message = "영화 줄거리를 입력하세요:";
        movieDTO.setContent(ScannerUtil.nextLine(scanner, message));

        message = "영화 등급을 입력하세요:";
        movieDTO.setLevel(ScannerUtil.nextInt(scanner, message));

        movieController.insert(movieDTO);
        System.out.println("영화가 성공적으로 등록되었습니다.");
    }


}













