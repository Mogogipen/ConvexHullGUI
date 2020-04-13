package GUI;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ConvexHullPanel extends JPanel implements MouseListener {
	
	private ArrayList<Point> hullFrame = new ArrayList<Point>();
	private ArrayList<Point> points = new ArrayList<Point>();

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
		
		// Draw lines
		for (int i = 0; i < hullFrame.size(); i++) {
			int j = i+1;
			if (j == hullFrame.size())
				j = 0;
			g.drawLine(hullFrame.get(i).x, hullFrame.get(i).y, hullFrame.get(j).x, hullFrame.get(j).y);
		}
	}
	
	public void addPoint(int x, int y) {
		Point temp = new Point(x, y);
		points.add(temp);
	}

	public void clearField() {
		// Save old frame
		ArrayList<Point> oldHullFrame = new ArrayList<Point>();
		for (Point p : hullFrame) {
			oldHullFrame.add(p);
		}
		
		// Save old points
		ArrayList<Point> oldPoints = new ArrayList<Point>();
		for (Point p : points) {
			oldPoints.add(p);
		}
		
		// Clear old lists
		hullFrame.clear();
		points.clear();
		repaint();
	}
	
	// Method which adds the hull frame around the points (it calls the algorithm method).
	public void drawConvexHull() {
		hullFrame = ConvexHull.convexHull(points, points.size());
		repaint();
	}
	
	//
	// Set MouseEvents
	//

	@Override
	public void mouseClicked(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }

	@Override
	public void mousePressed(MouseEvent e) {
		addPoint(e.getX(), e.getY());
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) { }
	
}
