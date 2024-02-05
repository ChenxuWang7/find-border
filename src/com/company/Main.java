package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


/*

Find the all the points of land board by dfs
Input: grid = [
            ["1","1","1","0","0","0"],
            ["1","1","0","0","0","0"],
            ["1","1","0","0","1","0"],
            ["1","1","0","1","1","0"],
            ["1","1","1","1","1","0"],
            ["1","1","1","0","0","0"]
            ]
Output: [0, 2], [1, 1], [2, 1], [2, 4], [3, 1], [3, 3], [3, 4], [4, 2], [4, 3], [4, 4] [5, 2]
 */


    public static void main(String[] args) {
	// write your code here
        Integer[][] land = new Integer[][] {
                {1,1,1,0,0,0},
                {1,1,0,0,0,0},
                {1,1,0,0,1,0},
                {1,1,0,1,1,0},
                {1,1,1,1,1,0},
                {1,1,1,0,0,0}};
        findBorder(land);

        res.forEach(a -> System.out.println(Arrays.deepToString(a)));
    }


    public final static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static int m, n;
    public static List<Integer[]> res = new ArrayList<>();

    public static void findBorder(Integer[][] land) {
        m = land.length;
        n = land[0].length;
        boolean[][] seen = new boolean[m][n];


        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(land[i][j] == 1 && !seen[i][j]) {
                    dfs(land, i, j, seen);
                    seen[i][j] = true;
                }
            }
        }

    }

    private static void dfs(Integer[][] land, int i, int j, boolean[][] seen) {
        if(i < 0 || i >= m || j < 0 || j>= n || land[i][j] == 0 || seen[i][j]) return;

        for(int[] d : dirs){
            int newX = i + d[0];
            int newY = j + d[1];
            if(newX >= 0 && newX < m && newY >= 0 && newY < n && land[newX][newY] == 0){
                res.add(new Integer[]{i, j});
                break;
            }
            seen[i][j] = true;
        }


    }
}
