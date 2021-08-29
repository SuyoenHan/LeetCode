class Solution {
    public int islandPerimeter(int[][] grid) {
          int col = grid[0].length;
    int row = grid.length;
    int count = 0;
    int answer = 0;
    for (int i = 0; i < row; i++) { // 행
      for (int j = 0; j < col; j++) { // 열

        // 3) count 초기화
        count = 0;

        // 1) 땅인 경우 겉넓이 계산을 위해 주변에 땅이 있는지 확인
        if (grid[i][j] == 1) {
          if (j != 0) {
            if (grid[i][j - 1] == 1)
              count++; // 왼쪽
          }

          if (j != col - 1) {
            if (grid[i][j + 1] == 1)
              count++; // 오른쪽
          }

          if (i != 0) {
            if (grid[i - 1][j] == 1)
              count++; // 위쪽
          }

          if (i != row - 1) {
            if (grid[i + 1][j] == 1)
              count++; // 아래쪽
          }

          // 2) 겉넓이 누적
          answer = answer + 4 - count;

        } // end of if(grid[i][j]==1){
      }
    }
    return answer;
    }
}