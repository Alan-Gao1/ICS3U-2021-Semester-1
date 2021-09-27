package Week2.Week4;

public class BayviewGlenPools {
    public static void main(String[] args) {
        final int length = 50;
        final int width = 20;
        final int transition = 7;
        final int shallowLength = 20;
        final int shallowHeight = 2;
        final int deepHeight = 5;
        final double linerCost = 0.5;
        /*final int length = 20;
        final int width = 8;
        final int transition = 7;
        final int shallowLength = 5;
        final int shallowHeight = 3;
        final int deepHeight = 8;
        final double linerCost = 2.0;*/
        System.out.println("List of values used:\nLength: "+length+"\nWidth: "+width+"\nTransition Length: "+transition+"\nLength of the Shallow End: "+shallowLength+"\nHeight of the Shallow End: "+shallowHeight+"\nHeight of the Deep End: "+deepHeight+"\nCost of the Liner: "+linerCost+"\n");
        System.out.println("Calculations:");
        System.out.println("Volume of the pool at 90% capacity: "+round((calculateVolume(shallowLength, shallowHeight, deepHeight, calculateStraightTransition(transition, shallowHeight, deepHeight), length, width))*0.9));
        System.out.println("Surface Area of the Liner: "+round(amountOfLiner(shallowLength, shallowHeight, deepHeight, calculateStraightTransition(transition, shallowHeight, deepHeight), transition, length, width))+" m^2");
        System.out.println("Cost of the Liner: "+round(costOfLiner(amountOfLiner(shallowLength, shallowHeight, deepHeight, calculateStraightTransition(transition, shallowHeight, deepHeight), transition, length, width), linerCost)));
    }
    public static double round(double num){
        num += 0.005;
        num *=100;
        num = (int)num;
        num = (double)num;
        num /= 100;
        return num;
    }
    public static double calculateStraightTransition(int transition, int shallowHeight, int deepHeight){
        double straightTransition = Math.sqrt(Math.pow((double)transition, 2)-Math.pow((double)(deepHeight-shallowHeight), 2));
        return straightTransition;
    }
    public static double calculateVolume(int shallowLength, int shallowHeight, int deepHeight, double straightTransition, int length, int width){
        double deepVolume = deepHeight*(length-shallowLength-straightTransition)*width;
        double transitionVolume = (straightTransition*shallowHeight*width)+((((deepHeight-shallowHeight)*straightTransition)/2)*width);
        double shallowVolume = shallowLength*shallowHeight*width;
        return deepVolume+transitionVolume+shallowVolume;
    }
    public static double amountOfLiner(int shallowLength, int shallowHeight, int deepHeight, double straightTransition, int transition, int length, int width){
        double deepLength = (double)length-straightTransition-(double)shallowLength;
        double deepWalls = (deepHeight*width)+(deepHeight*deepLength)+(deepHeight*deepLength);
        double deepFloor = width*deepLength;
        double shallowWalls = (shallowHeight*width)+(shallowHeight*shallowLength)+(shallowHeight*shallowLength);
        double shallowFloor = width*shallowLength;
        double transitionWalls = (straightTransition*shallowLength*2)+(straightTransition*(deepHeight-shallowHeight));
        double transitionFloor = transition*width;
        return deepWalls+deepFloor+shallowFloor+shallowWalls+transitionWalls+transitionFloor;
    }
    public static double costOfLiner(double amountOfLiner, double linerCost){
        return amountOfLiner*linerCost;
    }
}
