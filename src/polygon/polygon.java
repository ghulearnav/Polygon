package polygon;

import javax.swing.*;//real
import java.awt.*;
import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;


public class polygon {
List<lineseg> line = new ArrayList<lineseg>();
List<point> pt = new ArrayList<point>();

	polygon(){
		line.add(new lineseg());
	}
	polygon(point[] pt,int i){
		
		line.add(new lineseg(pt[0], pt[i]));
		for(int x = 1; x<= i;x++) {
			line.add(new lineseg(pt[x],pt[x-1]));
		}
		for(int x = 0; x<= i;x++) {
		this.pt.add(pt[x]);
		}
	}
	public double perimiter() {
		double perim = 0;
		for(int i = 0; i <= line.size()-1; i++) {
			perim += line.get(i).findDistance();
		}
		return perim;
	}
	public void load(String path) {
		//TODO: file ingest with a bunch of points in a txt file.
		
	}
	public double area(int numpoi) {
		int len = numpoi-1;
		double l1 = 0;
		double l2 = 0;
		//double ld;
		for (int i = 0; i<=(len-1);i++) {
			l1 =+ pt.get(i).getX() * pt.get(i + 1).getY();
			l2 =+ pt.get(i).getY() * pt.get(i + 1).getX();
		}
		l1 = l2 +(pt.get(len).getX() * pt.get(1).getY());
		l2 = l1 +(pt.get(len).getY() * pt.get(1).getX());
		return Math.abs(l2-l1);
	}
}