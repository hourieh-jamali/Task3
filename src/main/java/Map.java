import java.util.List;

public class Map {
    private Integer wide;
    private Integer height;
    private List<ObstacleInfo> obstacleInfos;
    public   int[][] map;


    public Map(Integer wide, Integer height, List<ObstacleInfo> obstacleInfos) {
        this.wide = wide;
        this.height = height;
        this.obstacleInfos = obstacleInfos;
        prepareMap();
    }
    
    
    private void prepareMap(){
        map = new int[wide][height];
        for (int i = 0; i < wide; i++) {
            for (int j = 0; j < height; j++) {
                map[i][j] = Integer.MAX_VALUE;
            }
        }
        for (ObstacleInfo info : this.obstacleInfos) {
            for (int i = info.getX1(); i <= info.getX2(); i++) {
                for (int j = info.getY1(); j < info.getY2(); j++) {
                    map[i][j] = -1;
                }
            }
        }
    }

    public Integer getWide() {
        return wide;
    }

    public Integer getHeight() {
        return height;
    }
}
