package viewer;

import controller.MovieController;
import lombok.Setter;
import model.MovieDTO;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieViewer {
    @Setter
    MovieDTO movieDTO;
    @Setter
    MovieController movieController;
    @Setter
    MovieDTO logIn;
    @Setter
    Scanner scanner;


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

    }

    private void movieList(){
        ArrayList <MovieDTO> list = (ArrayList<MovieDTO>) movieController.selectAll();
        for(MovieDTO m : list){
            System.out.printf("%d. %s (%d세)\n", m.getId(), m.getTitle(), m.getLevel());
        }

        String message = "상세보기할 영화 번호를 선택하세요";
        int choice = ScannerUtil.nextInt(scanner, message);
        while(!movieController.validateInput(choice)){
            System.out.println("잘못 입력하셨습니다");
            choice = ScannerUtil.nextInt(scanner, message);
        }
        if(choice != 0){
            printOne(choice);
        }
    }

    private void printOne(int id){
        MovieDTO movieDTO = movieController.selectOne(id);
        System.out.println("==============================");
        System.out.println(movieDTO.getId()+"번");
        System.out.println("제목 : "+movieDTO.getTitle());
        System.out.println("줄거리: "+movieDTO.getContent());
        System.out.println("상영등급 : "+movieDTO.getLevel());
        System.out.println("--------------------------------");
        if(movieDTO.getId() == movieDTO.getId()){
            String message ="1. 수정 2. 삭제 3. 뒤로가기";
            int choice = ScannerUtil.nextInt(scanner, message);
                if(choice == 1){

                }else if(choice ==2){

                }else if(choice ==3 ){
                    modifyMovie();
                }
            }
        }
    }



