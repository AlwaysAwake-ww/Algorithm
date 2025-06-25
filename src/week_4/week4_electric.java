package week_4;


// https://school.programmers.co.kr/learn/courses/30/lessons/86971
// 전력망을 둘로 나누기

import java.util.*;

public class week4_electric {

    public int solution(int n, int[][] wires) {
        int answer = -1;

        // 여기서 노드 간선 하나씩 끊기
        for(int i=0; i<wires.length; i++){

            // 그래프 초기화
            List<List<Integer>> list = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                list.add(new ArrayList<>());
            }

            // 간선 연결
            for(int j=0; j<wires.length; j++){

                if(i == j) continue;
                int a = wires[j][0];
                int b = wires[j][1];

                list.get(a).add(b);
                list.get(b).add(a);
            }

            int[] visited = new int[n+1];
            Arrays.fill(visited, 0);

            int cnt = dfs(1, list, visited);
            int diff = Math.abs(n - 2 * cnt);
            if (answer == -1 || diff < answer) {
                answer = diff;
            }
        }

        return answer;
    }


    // dfs 는 단순히 연결되어있는 노드 개수 구하는데 사용
    public int dfs(int node, List<List<Integer>> list, int[] visited){

        visited[node] = 1;

        int cnt = 1;

        // 현재 노드와 연결된 간선 탐색
        for(int i : list.get(node)){

            if(visited[i] != 1){
                cnt += dfs(i, list, visited);
            }
        }

        return cnt;
    }
}
