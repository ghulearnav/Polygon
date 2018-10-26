package polygon;
public class lineseg {
	private point p1;
	private point p2;
	
	public lineseg() {
		p1.setX(0);
		p1.setY(0);
		p2.setX(0);
		p2.setY(0);
	}
	public lineseg(point pA, point pB) {
		p1=pA;
		p2=pB;
	}
	public void setP(double a, double b) {
		p1.setX(a);
		p1.setY(b);
	}
	public void setP1(point pA) {
		p1=pA;
	}
	public point getP1() {
		return p1;
	}
	public void setP2(point pB) {
		p2=pB;
	}
	public point getP2() {
		return p2;
	}
	public double findSlope() {
		double dx, dy;
		dx = p2.getX() - p1.getX();
		dy = p2.getY() - p1.getY();
		return dy/dx;
	}
	public double findDistance() {
		double dx, dy;
		dx = p2.getX() - p1.getX();
		dy = p2.getY() - p1.getY();
		return Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2));
	}
	public point findMidpoint() {
		point mp = new point();
		mp.setX((p1.getX()+p2.getX())/2);
		mp.setY((p1.getY()+p2.getY())/2);
		return mp;
	}
	public String toString() {
		return p1.toString()+"-"+p2.toString() + "\n"+
				"Slope:    " + findSlope() + "\n" +
				"Distance: "+findDistance()+ "\n"+
				"Midpoint: " + findMidpoint().toString()+"\n";
	}
}
