package etc;

public class Combination {

    public void combination(int[] arr, int depth, int start, int r){

        if (depth == r) {
            printFirstR(arr, r);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            // 현재 조합 자리에 고정
            swap(arr, depth, i);
            combination(arr, depth + 1, i + 1, r);
            swap(arr, depth, i);
        }
    }

    // 숫자 swap 함수
    private void swap(int arr[], int a, int b){

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    // 배열 출력
    private void printFirstR(int[] arr, int r) {
        for (int i = 0; i < r; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
