package Week9;

/*
We are inheriting everything from rectangle into Box
*/
public class Box extends Rectangle{
    /**
     * If you do not write an explicit constructor then Java supplies this one for you
     * It does NOTHING except call your parents no-argument contructor
     
    public Box(){
        // super is the parent class (in this case Rectangle)
        super();
    }
    */

    private double height;

    public Box(double l, double w, double h){
        // length = l; //child classes do not have direct access to their parents privatre attributes and methods
        // width = w;
        super(l,w); //this must me the first statement in your constructor class
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

    /*
    really just gets all the edges
    */
    public double getPerimeter(){
        return super.getPerimeter()*2 + 4*height;
    }
}
