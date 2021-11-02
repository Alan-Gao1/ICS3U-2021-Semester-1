package Week9;

/*
We are inheriting everything from rectangle into Box
*/
public class Box extends Rectangle{

    private double height;

    public Box(double l, double w, double h){
        super(l,w);
        height = h;
    }



    public Box(double side){
        super(side);
        height = side;
    }

    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj instanceof Box){
            Box b = (Box)obj;
            return this.getLength()==b.getLength() && this.getLength()==b.getLength() && this.height == b.height;
        }

        return false;
    }

    public double getArea(){
        return 2*super.getArea() + getLength()*height*2 + getWidth()*height*2;
    }

    public double getVolume(){
        return super.getArea()*height;
    }

    public String toString(){
        return "Box with length of "+super.getLength()+" and width of "+super.getWidth()+" and height of "+height+" and volume of "+getVolume();
    }

    public double getPerimeter(){
        return super.getPerimeter()*2 + 4*height;
    }
}
