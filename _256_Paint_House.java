/**
 * Created by Junyan Zhang on 1/31/2018.
 */
public class _256_Paint_House {
    /**
     There are a row of n houses, each house can be painted with one of the three colors:
     red, blue or green. The cost of painting each house with a certain color is different.
     You have to paint all the houses such that no two adjacent houses have the same color.
     The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example,
     costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with
     color green, and so on... Find the minimum cost to paint all houses.
     costs[i][j]
     i : house
     j : color : 3

     题意：
         有一排房子，每一栋房子可以被刷成红、蓝、绿三种颜色之一，刷每种颜色的成本也各不相同。你需要把所有房子刷上油漆，
         相邻的两座房子不能有相同的颜色，刷每座房子的成本表示为一个n x 3的矩阵。例如，cost[0][0]是把0号房子刷成红色
         的成本；cost[1][2]是把1号房子刷成绿色的成本，等等。请找到给所有房子涂上油漆的最小成本。


     思路：
         比较简单的动态规划，直接就可以解决。如果cost数组允许修改可以直接利用cost数组存储。


     复杂度：
        time : O(n)
        space : O(1)

     */
    public int minCost(int[][] costs) {
        if (costs == null || costs[0].length == 0) return 0;
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        int n = costs.length - 1;
        return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
    }
}
