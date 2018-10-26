package polygon;

public class point {
	private double x;
	private double y;
	double wx,wy;
	
	
	public point(){
		x=0;
		y=0;
	}
	public point(double xval, double yval) {
		x=xval;
		y=yval;
	}
	public void drawpt(double xi, double yi){
		wx = xi;
		wy = yi;
	}
	public void setX(double xval) {
		this.x=xval;
	}
	public double getX() {
		return x;
	}
	public void setY(double yval) {
		y=yval;
	}
	public double getY() {
		return y;
	}
	public String toString() {
		return "("+x+", "+y+")";
	}
}
