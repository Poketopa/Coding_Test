
import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        List<int[]>[] list = new List[node + 1];
        for(int i=0;i<list.length;i++) list[i] = (new ArrayList<>());
        // n행은 n번째 학생의 파티로 가는 distance
        int[][] distance = new int[node + 1][node + 1];
        for(int i=0;i<distance.length;i++) Arrays.fill(distance[i], Integer.MAX_VALUE);
        for(int i=1;i<distance.length;i++) distance[i][i] = 0;
        for(int i=0;i<edge;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st2.nextToken());
            int temp2 = Integer.parseInt(st2.nextToken());
            int temp3 = Integer.parseInt(st2.nextToken());
            distance[temp1][temp2] = temp3;
        }

        // i 경유노드
        for(int i=1;i<distance.length;i++){
            // j 출발노드
            for(int j=1;j<distance.length;j++){
                // k 도착노드
                for(int k=0;k<distance.length;k++){
                    if(distance[j][i] == Integer.MAX_VALUE || distance[i][k] == Integer.MAX_VALUE) continue;
                    if(distance[j][k] > distance[j][i] + distance[i][k]){
                        distance[j][k] = distance[j][i] + distance[i][k];
                    }
                }
            }
        }
        int max = -1;

        for(int i=1;i<distance.length;i++){
            max = Math.max(distance[i][target] + distance[target][i], max);
        }

        System.out.println(max);


    }
}
