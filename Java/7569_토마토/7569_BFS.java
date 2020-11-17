import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][][] tomatoes = new int[N][M][H];
        int day = -1;
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        for(int k = 0; k < H; k++) {
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int i = 0; i < M; i++) {
                    int n = Integer.parseInt(st.nextToken());
                    if (n == 1) {
                        q1.add(new Node(j, i, k));

                    }
                    tomatoes[j][i][k] = n;
                }
            }
        }

        while(!q1.isEmpty() || !q2.isEmpty()) {
            Queue get, put;
            day++;
            if(!q1.isEmpty()) {
                get = q1;
                put = q2;
            }
            else {
                get = q2;
                put = q1;
            }
            while(!get.isEmpty()) {
                Node cur = (Node) get.poll();
                int tx = cur.x;
                int ty = cur.y;
                int tz = cur.z;

                if(tx + 1 < N) {
                    if(tomatoes[tx + 1][ty][tz] == 0) {
                        tomatoes[tx + 1][ty][tz] = 1;
                        put.add(new Node(tx+1, ty, tz));
                    }
                }

                if(0 <= tx - 1) {
                    if(tomatoes[tx - 1][ty][tz] == 0) {
                        tomatoes[tx - 1][ty][tz] = 1;
                        put.add(new Node(tx-1, ty, tz));
                    }
                }

                if(ty + 1 < M) {
                    if(tomatoes[tx][ty + 1][tz] == 0) {
                        tomatoes[tx][ty + 1][tz] = 1;
                        put.add(new Node(tx, ty + 1, tz));
                    }
                }

                if(0 <= ty - 1) {
                    if(tomatoes[tx][ty - 1][tz] == 0) {
                        tomatoes[tx][ty - 1][tz] = 1;
                        put.add(new Node(tx, ty-1, tz));
                    }
                }

                if(tz + 1 < H) {
                    if(tomatoes[tx][ty][tz + 1] == 0) {
                        tomatoes[tx][ty][tz + 1] = 1;
                        put.add(new Node(tx, ty, tz + 1));
                    }
                }

                if(0 <= tz - 1) {
                    if(tomatoes[tx][ty][tz - 1] == 0) {
                        tomatoes[tx][ty][tz - 1] = 1;
                        put.add(new Node(tx, ty, tz - 1));
                    }
                }
            }
        }

        boolean ripe = true;
        for(int k = 0; k < H && ripe; k++) {
            for (int i = 0; i < N && ripe; i++) {
                for (int j = 0; j < M && ripe; j++) {
                    if(tomatoes[i][j][k] == 0) ripe = false;
                }
            }
        }
        if (!ripe) day = -1;
        bw.write(day + "\n");
        bw.flush();
        bw.close();
    }
}

class Node {
    public int x, y, z;
    public Node(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
