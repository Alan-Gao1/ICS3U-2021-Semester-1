package Week9;

public class ShapeDriver {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(3, 4);
        Rectangle r2 = new Rectangle(1, 2);

        System.out.println("Perimeter of r1: "+r1.getPerimeter());
        System.out.println("Area of r2: "+r2.getArea());
        if(r1.equals(r2)){
            System.out.println("The rectangles are equal.");
        }else{
            System.out.println("The rectangles are not equal");
        }

        System.out.println(r1);
        System.out.println(r2);


        Box box1 = new Box(5, 6, 2);
        Box box2 = new Box(7);

        System.out.println(box2);
        System.out.println("Volume of box1: "+box1.getVolume());
    }
}
