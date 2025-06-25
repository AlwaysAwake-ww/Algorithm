package week_4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// 미로 탈출
// https://school.programmers.co.kr/learn/courses/30/lessons/159993

public class week4_maze {

    static int[] dx = {0, 0 ,1, -1};
    static int[] dy = {1, -1, 0, 0};

    public int solution(String[] maps) {
        int answer = 0;

        String[][] map = new String[maps.length][maps[0].length()];

        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];

        // String[] 배열을 map으로
        for(int i=0; i<maps.length;i++){
            for (int j = 0; j < maps[i].length(); j++) {
                char ch = maps[i].charAt(j);
                if(ch == 'S'){
                    map[i][j] = "S";
                    start[0] = i;
                    start[1] = j;
                } else if(ch == 'L'){
                    map[i][j] = "L";
                    lever[0] = i;
                    lever[1] = j;
                } else if(ch == 'E'){
                    map[i][j] = "E";
                    end[0] = i;
                    end[1] = j;
                }
                else if(ch == 'X')
                    map[i][j] = "X";
                else if(ch == 'O')
                    map[i][j] = "O";
            }
        }

        int a = bfs(map, start, lever);
        int b = bfs(map, lever, end);

        if(a != -1 && b != -1)
            return a+b+2;
        else return -1;

    }


    public int bfs(String[][] map, int[] start, int[] end){

        int n = map.length;
        int m = map[0].length;

        // bfs 사용을 위한 큐
        Queue<int[]> q = new LinkedList<>();

        // 방문 노드 체크
        int[][] distance = new int[map.length][map[0].length];
        for(int[] v : distance)
            Arrays.fill(v, -1);

        int curX = start[0];
        int curY = start[1];

        // q에 시작값 삽입
        q.add(new int[]{curX, curY});

        // 반복
        while(!q.isEmpty()){
            System.out.println(q.size());
            int[] now = q.poll();
            curX = now[0];
            curY = now[1];

            // 목적지 도착
            if (curX == end[0] && curY == end[1]) {
                return distance[curX][curY];
            }

            // 4방향 탐색
            for(int i=0; i<4; i++){
                int newX = curX+dx[i];
                int newY = curY+dy[i];

                // 미로 범위 바깥일 경우, 이미 방문한경우, 벽인경우 >> 무시
                if (newX < 0 || newX >= n || newY < 0 || newY >= m || distance[newX][newY] > 0 || map[newX][newY].equals("X")) {
                    continue;
                }

                // 방문횟수 + 1
                distance[newX][newY] = distance[curX][curY] + 1;
                q.add(new int[]{newX, newY});
            }
        }

        // 목적지까지 경로 없는경우 -1 return
        return -1;
    }

}
