package week_5;


// 조이스틱
// https://school.programmers.co.kr/learn/courses/30/lessons/42860
public class week5_joystick {

    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public int solution(String name) {
        int answer = 0;

        int horizontal = horizontal(name);
        for (char c : name.toCharArray()) {

            int vertical = vertical(c);

            System.out.println("A to " + c + ": " + vertical);
            answer += vertical;
        }
        return answer + horizontal;
    }

    private int horizontal(String name) {
        int len = name.length();
        int minMove = len - 1; // 초기값: 오른쪽으로 쭉 이동

        for (int i = 0; i < len; i++) {
            int next = i + 1;

            // 연속된 'A'가 있는 부분 skip
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }

            // 처음부터 i까지 가고 → 뒤로 돌아가서 끝까지
            int moveCase1 = i * 2 + (len - next);
            // 끝까지 갔다가 < 돌아와서 i까지
            int moveCase2 = (len - next) * 2 + i;

            minMove = Math.min(minMove, Math.min(moveCase1, moveCase2));
        }

        return minMove;
    }

    private int vertical(char c) {

        // 여기에 위, 아래로 돌리는거 중 뭐가 더 빠른가 판단
        // 시작은 무조건 A
        int from = 0;
        int to = alphabet.indexOf(c);
        return Math.min(Math.abs(to - from), 26 - Math.abs(to - from));
    }
}
