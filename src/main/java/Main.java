import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static  int[][] SPEEDS = {{0,0}, {0,1}, {0,-1},{1,0}, {1,1}, {1,-1},{-1,0}, {-1,1}, {-1,-1}};
    static  int[][] MOVES = {{0,1}, {1,0}, {0,-1},{-1,0}};
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        Integer numTests = scanner.nextInt();

        for (int i = 0; i < numTests; i++) {
            Integer wide = scanner.nextInt();
            Integer height = scanner.nextInt();

            Integer startX = scanner.nextInt();
            Integer startY = scanner.nextInt();
            Integer endX = scanner.nextInt();
            Integer endY = scanner.nextInt();
            Integer numObstacles = scanner.nextInt();
            List<ObstacleInfo> obstacleInfos = new ArrayList<>();
            for (int j = 0; j < numObstacles; j++) {
                Integer x1 = scanner.nextInt();
                Integer x2 = scanner.nextInt();
                Integer y1 = scanner.nextInt();
                Integer y2 = scanner.nextInt();

                ObstacleInfo obstacleInfo = new ObstacleInfo(x1, x2, y1, y2);
                obstacleInfos.add(obstacleInfo);
            }

            Map map = new Map(wide, height, obstacleInfos);
            map.map[startX][startY] = 0;
            search(map, startX, startY, 0, 0);

            if(map.map[endX][endY] == Integer.MAX_VALUE){
                System.out.println("No solution.");
            }else{
                System.out.println("Optimal solution takes "+map.map[endX][endY]+" hops.");
            }
        }


    }


    private static void search(Map map, int startX, int startY, int speedX, int speedY) {
        for (int[] speed : SPEEDS) {
            int newSpeedX = speed[0] + speedX;
            int newSpeedY = speed[1] + speedY;
            if(newSpeedX >= 0 &&  newSpeedY >=0 && (newSpeedY >0 || newSpeedX > 0)){
                for (int[] move : MOVES){
                    int newX = startX + newSpeedX * move[0];
                    int newY = startY + newSpeedY * move[1];
                    if(newX > 0 && newX < map.getWide() && newY > 0 && newY < map.getHeight()){
                        if(map.map[newX][newY] == -1)
                            continue;
                        int preCount = map.map[startX][startY];
                        int newCount = map.map[newX][newY];
                        if(preCount + 1 < newCount){
                            map.map[newX][newY] = preCount+1;
                            search(map, newX , newY , newSpeedX, newSpeedY);
                        }
                    }
                }
            }
        }
    }



}
