package polygon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ColorPanel extends JPanel implements ActionListener, MouseListener{
	int ii = 0;
	point p[] = new point[21];
	int numpoi;
	
	public ColorPanel(int nump) {
		setBackground(Color.white);
		numpoi = nump;
		addMouseListener(this); 
		
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int x = getWidth()/2;
		int y = getHeight()/2;
		g.drawLine(x, 0, x, getHeight());
		g.drawLine(0, y, getWidth(), y);
		g.drawOval(getWidth()/2 - 2, getHeight()/2- 2, 5, 5);
		g.drawString("(0,0)", getWidth()/2+10, getHeight()/2+10);
		
		int j = 0;
		for(int i = (getWidth()/2)+50; i <= getWidth(); i += 50) {
			j++;
			g.drawLine(i, (getHeight()/2)-10, i, (getHeight()/2)+10);
			g.drawString(Integer.toString(j), i, (getHeight()/2)+20);
		}
		j=0;
		for(int i = (getWidth()/2)-50; i >= 0; i -= 50) {
			j--;
			g.drawLine(i, (getHeight()/2)-10, i, (getHeight()/2)+10);
			g.drawString(Integer.toString(j), i, (getHeight()/2)+20);
		}
		j=0;
		for(int i = (getHeight()/2)+50; i <= getHeight(); i += 50) {
			j--;
			g.drawLine((getWidth()/2)-10, i, (getWidth()/2)+10, i);
			g.drawString(Integer.toString(j),(getWidth()/2)+20, i);
		}
		j=0;
		for(int i = (getHeight()/2)-50; i >= 0; i -= 50) {
			j++;
			g.drawLine((getWidth()/2)-10, i, (getWidth()/2)+10, i);
			g.drawString(Integer.toString(j),(getWidth()/2)+20, i);
		}
		j=0;
		
		
		
	}
	
	public void drawCircle(int x, int y) {
        Graphics g = this.getGraphics();
        g.setColor(Color.BLACK);
        g.fillOval(x, y, 5, 5);
        g.drawString("("+(x-(getWidth()/2.0))/50.0+","+-(y-(getWidth()/2.0))/50.0+")", x+10, y+10);
    }
	public void drawline(int x1, int y1, int x2, int y2) {
		Graphics g = this.getGraphics();
		g.setColor(Color.BLACK);
		g.drawLine(x1,y1,x2,y2);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Graphics g = this.getGraphics();
		System.out.println(ii);
		if (ii <= numpoi-1) {
			if (ii == 0) {
				int x1 = e.getX(); 
				int y1 = e.getY();
				p[ii] = new point((e.getX()-(getWidth()/2.0))/50.0, (e.getY()-(getHeight()/2.0))/50.0);
				p[ii].drawpt(e.getX(), e.getY());
				System.out.println(p[ii].toString());
				drawCircle((int)p[ii].wx, (int)p[ii].wy);
				ii++;
			}else{
				int x1 = e.getX(); 
				int y1 = e.getY();
				p[ii] = new point((e.getX()-(getWidth()/2.0))/50.0, (e.getY()-(getHeight()/2.0))/50.0);
				p[ii].drawpt(e.getX(), e.getY());
				
				System.out.println(p[ii].toString());
				
				for(int x = 0; x<= ii; x++) {
					drawCircle((int)x1, (int)y1);
					drawline((int)x1, (int)y1, (int)p[ii-1].wx, (int)p[ii-1].wy);
					
				}
				ii++;
				if(ii==numpoi)
					drawline((int)p[ii-1].wx, (int)p[ii-1].wy, (int)p[0].wx, (int)p[0].wy);			}
		} else {
			
			//print the stuff
			System.out.println("we made it bois");
			polygon poly = new polygon(p,numpoi-1);
			System.out.println("area: " +  poly.area(numpoi));
			System.out.println("perimiter: " + poly.perimiter());
		}
		/*
		switch(ii){
		case 1:
			point a = new point(e.getX(),e.getY());
			p[1]=a;
			drawCircle((int)a.getX(),(int)a.getY());
			ii++;
			break;
		case 2:
			point b = new point(e.getX(),e.getY());
			p[2]=b;
			drawCircle((int)b.getX(),(int)b.getY()); 
			g.drawLine(e.getX(),e.getY(),(int)p[1].getX(),(int)p[1].getY());
			ii++;
			break;
		case 3:
			point c = new point(e.getX(),e.getY());
			p[3]=c;
			drawCircle((int)c.getX(),(int)c.getY()); 
			g.drawLine(e.getX(),e.getY(),(int)p[2].getX(),(int)p[2].getY());
			g.drawLine(e.getX(),e.getY(),(int)p[1].getX(),(int)p[1].getY());
			ii++;
			break;	
		case 4:			
		
			point d = new point(e.getX(),e.getY());
			p[4]=d;
			drawCircle(e.getX(), e.getY());
			drawCircle((int)p[1].getX(),(int)p[1].getY());
			drawCircle((int)p[2].getX(),(int)p[2].getY());
			drawCircle((int)p[3].getX(),(int)p[3].getY());
			g.drawLine((int)p[1].getX(),(int)p[1].getY(),(int)p[2].getX(),(int)p[2].getY());
			g.drawLine((int)p[2].getX(),(int)p[2].getY(),(int)p[3].getX(),(int)p[3].getY());
			g.drawLine((int)p[3].getX(),(int)p[3].getY(),(int)p[4].getX(),(int)p[4].getY());
			g.drawLine((int)p[4].getX(),(int)p[4].getY(),(int)p[1].getX(),(int)p[1].getY());
			ii++;
			break;		
		}
		*/

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}