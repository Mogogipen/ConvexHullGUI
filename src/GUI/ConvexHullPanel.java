package GUI;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ConvexHullPanel extends JPanel implements MouseListener {
	
	ArrayList<Point> points = new ArrayList<Point>();
	
	int mouseX;
	int mouseY;

	public ConvexHullPanel() {
		super();
		
		this.addMouseListener(this);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		// Draw points
		for (Point p : points) {
			int size = 4;
			g.drawOval(p.x - size/2, p.y - size/2, size, size);
			g.fillOval(p.x - size/2, p.y - size/2, size, size);
		}
	}
	
	public void addPoint(int x, int y) {
		points.add(new Point(x, y));
	}

	@Override
	public void mouseClicked(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }

	@Override
	public void mousePressed(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		addPoint(mouseX, mouseY);
		
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) { }
	
}
