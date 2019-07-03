package packer;

/**
 * Represents location of coordinates.
 * Also determines distances from two coordinates using a proprietary distance metric.
 * 
 * @author I.M.Bad, Charles Tsao
 * @version 1.0
 */
public class Coordinates {
    
    private final double x;
    private final double y;
    
    /**
    * @param x X-axis location of coordinate point
    * @param y Y-axis location of coordinate point
    */
    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
    * @return X-axis location of coordinate point
    */
    public double getX() {
        return x;
    }

    /**
    * @return Y-axis location of coordinate point
    */
    public double getY() {
        return y;
    }

    /**
    * @param other Coordinate location of the other point
    * @return The Euclidean distance between a point and another point
    */    
    public double euclideanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.pow((xDiff * xDiff + yDiff * yDiff),0.5);
        return dist;
    }

    /**
    * @param other Coordinate location of the other point
    * @return The Manhattan distance between a point and another point
    */        
    public double manhattanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.abs(xDiff) + Math.abs(yDiff);
        return dist;
    }

    /**
    * @param other Coordinate location of the other point
    * @return The distance between a point and another point using the company's proprietary distance metric
    */     
    public double companyDistanceTo(Coordinates other) {
        double xDiff1 = other.getX() - this.getX();
        double yDiff1 = other.getY() - this.getY();
        double dist1 = Math.pow((xDiff1 * xDiff1 + yDiff1 * yDiff1), 0.5);
        double xDiff2 = other.getX() - this.getX();
        double yDiff2 = other.getY() - this.getY();
        double dist2 = Math.abs(xDiff2) + Math.abs(yDiff2);
        return (dist1 + dist2)/2 + 1; // ERROR: was missing +1 (km) for the company's proprietary distance metric
    }
}
