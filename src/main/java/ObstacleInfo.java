public class ObstacleInfo {
    private  Integer x1;
    private  Integer x2;
    private  Integer y2;
    private  Integer y1;

    public ObstacleInfo(Integer x1, Integer x2, Integer y2, Integer y1) {
        this.x1 = x1;
        this.x2 = x2;
        this.y2 = y2;
        this.y1 = y1;
    }

    public  boolean isOnObstacle(int x , int y){
        return  x >= this.x1 && x <= this.x2 && y >= y1 && y <= y2;
    }

    public Integer getX1() {
        return x1;
    }

    public Integer getX2() {
        return x2;
    }

    public Integer getY2() {
        return y2;
    }

    public Integer getY1() {
        return y1;
    }
}
