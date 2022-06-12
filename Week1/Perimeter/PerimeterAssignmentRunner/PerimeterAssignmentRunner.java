 

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int totalPoint = 0;
        for(Point currPt : s.getPoints()) {
            totalPoint ++;
        }
        return totalPoint;
    }

    public double getAverageLength(Shape s) {
        double sumOfSidesLength = getPerimeter(s);
        int numberOfPoint = getNumPoints(s);
        double averageLength = sumOfSidesLength/numberOfPoint;
        return averageLength;
    }

    public double getLargestSide(Shape s) {
        double largestSide = 0.0;
        Point prevPoint = s.getLastPoint();
        for(Point currPt : s.getPoints()){
            double distance = prevPoint.distance(currPt);
            if(distance > largestSide ) {
                largestSide = distance;
            }
            prevPoint = currPt;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = 0.0;
        double x = 0.0;
        for(Point p: s.getPoints()) {
            x = p.getX();
            if(x >= largestX) {
                largestX = x;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        double currPerimeter = 0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            currPerimeter = getPerimeter(s);
            if(currPerimeter >= largestPerimeter) {
                largestPerimeter = currPerimeter;
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        double currPerimeter = 0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            currPerimeter = getPerimeter(s);
            if(currPerimeter >= largestPerimeter) {
                largestPerimeter = currPerimeter;
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        printFileNames();
        double length = getPerimeter(s);
        int numberOfpoint = getNumPoints(s);
        double averageOfSidesLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("Number of point = " + numberOfpoint);
        System.out.println("averageOfSidesLength = " + averageOfSidesLength);
        System.out.println("largestSide = " + largestSide);
        System.out.println("largestX = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        String largestPerimeterMultipleFiles = getFileWithLargestPerimeter();
        System.out.println("testPerimeterMultipleFiles = " + largestPerimeterMultipleFiles);

    }

    public void testFileWithLargestPerimeter() {
        // Put code here
         double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("LargestPerimeterMultipleFiles = " + largestPerimeter);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        //pr.testFileWithLargestPerimeter();
        //pr.testPerimeterMultipleFiles();
    }
}
