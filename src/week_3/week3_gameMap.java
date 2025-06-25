package week_3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class week3_gameMap {

    public int solution(int[][] maps) {

        int answer = bfs(maps);
        return  answer == -1 ? -1 : answer + 1;
    }

    public int bfs(int[][] maps){
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        // 방문 노드
        int[][] visited = new int[maps.length][maps[0].length];
        for (int[] ints : visited) {
            Arrays.fill(ints, 0);
        }

        // 노드 큐
        Queue<int[]> q = new LinkedList<>();

        int[] start = {0,0};
        int[] end = {maps.length-1, maps[0].length-1};

        q.add(start);

        while(!q.isEmpty()){

            int[] cur = q.poll();

            // 도착지점
            if (cur[0] == end[0] && cur[1] == end[1]) {
                return visited[cur[0]][cur[1]];
            }
            
            // 4방향 탐색
            for (int n = 0; n < 4; n++) {
                int nextX = cur[0] + dx[n];
                int nextY = cur[1] + dy[n];

                // 범위 벗어났거나 벽일 경우, 이미 방문한 노드일 경우
                if (nextX < 0 || nextY < 0 || nextX >= maps.length || nextY >= maps[0].length || maps[nextX][nextY] == 0 || visited[nextX][nextY] != 0) {
                    continue;
                }

                visited[nextX][nextY] = visited[cur[0]][cur[1]] + 1;
                q.add(new int[]{nextX, nextY});
            }
        }
        return -1;
    }
}
