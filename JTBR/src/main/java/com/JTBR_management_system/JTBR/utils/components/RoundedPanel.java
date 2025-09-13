package com.JTBR_management_system.JTBR.utils.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class RoundedPanel extends JPanel{
	private int cornerRadius;

	public RoundedPanel(Color bgColor, int radius) {
		super();
		this.cornerRadius = radius;
		setBackground(bgColor);
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		Insets insets = getInsets(); 
		int x = insets.left;
		int y = insets.top;
		int width = getWidth() - insets.left - insets.right;
		int height = getHeight() - insets.top - insets.bottom;

		RoundRectangle2D roundedRect = new RoundRectangle2D.Float(x, y, width - 1, height - 1, cornerRadius,
				cornerRadius);

		g2d.setColor(getBackground());
		g2d.fill(roundedRect);

		g2d.dispose();
		super.paintComponent(g);
	}
}