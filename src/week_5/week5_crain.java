package week_5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 지게차와 크레인
// https://school.programmers.co.kr/learn/courses/30/lessons/388353
public class week5_crain {


    int[][] border;


    public int solution(String[] storage, String[] requests) {
        int answer = 0;


        String[][] input = new String[storage.length+2][storage[0].length()+2];
        border = new int[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (i == 0 || i == input.length - 1 || j == 0 || j == input[0].length - 1) {
                    border[i][j] = 1;
                }
            }
        }
        // 주어진 화물 정보 이차원 배열로
        // 테두리는 null
        for(int i=0; i<=storage.length-1; i++){
            String origin = storage[i];
            for(int j=0; j<= storage[i].length()-1; j++){
                input[i+1][j+1] = String.valueOf(origin.charAt(j));
            }
        }

        for (String s : requests){
            if(s.length()>=2)
                crain(input, s.substring(0,1));
            else
                bfs(input, s);

        }


        return count(input);
    }

    // 지게차
    private void bfs(String[][] input, String target) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[input.length][input[0].length];

        q.add(new int[]{0, 0});
        visited[0][0] = 1;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= input.length || ny >= input[0].length || visited[nx][ny] == 1) continue;


                visited[nx][ny] = 1;

                if (input[nx][ny] != null && input[nx][ny].equals(target)) {
                    border[nx][ny] = 1; // 근처에 있어서 접근 가능, 제거 대상
                } else if (input[nx][ny] == null) {
                    q.add(new int[]{nx, ny});
                }
            }
        }

        // 제거 수행
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (border[i][j] == 1 && input[i][j] != null && input[i][j].equals(target)) {
                    input[i][j] = null;
                }
            }
        }
    }

    // 크레인 사용
    private void crain(String[][] input, String target){

        for(int i=0; i<input.length; i++){
            for(int j=0; j<input[0].length; j++){
                if(input[i][j] !=null && input[i][j].equals(target)){
                    input[i][j]=null;
                    border[i][j]=1;
                }
            }
        }
    }


    // 정답 count
    private int count(String[][] input) {
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] != null) {
                    count++;
                }
            }
        }
        return count;
    }

}
