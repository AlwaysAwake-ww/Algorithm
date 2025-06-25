
package week_3;
import java.util.*;


// https://school.programmers.co.kr/learn/courses/30/lessons/389479
// 서버 증설 횟수
public class week3_server {
    public int solution(int[] players, int m, int k) {
        int[][] serverInfo = new int[2][24];
        Arrays.fill(serverInfo[0], 0);
        Arrays.fill(serverInfo[1], 0);

        for (int i = 0; i < 24; i++) {
            int need = players[i] / m;
            int curServer = serverInfo[0][i];

            if (need > curServer) {
                int upgrade = need - curServer;
                serverInfo[1][i] = (i == 0) ? need : serverInfo[1][i - 1] + upgrade;

                for (int j = i; j < i + k; j++) {
                    if (j <= 23) {
                        serverInfo[0][j] += upgrade;
                    } else {
                        break;
                    }
                }
            } else {
                serverInfo[1][i] = (i == 0) ? need : serverInfo[1][i - 1];
            }
        }
        return serverInfo[1][23];
    }

}
