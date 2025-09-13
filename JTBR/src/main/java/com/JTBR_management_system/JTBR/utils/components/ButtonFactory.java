package com.JTBR_management_system.JTBR.utils.components;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JButton;
import org.jetbrains.annotations.Nullable;
import com.JTBR_management_system.JTBR.utils.Colors;

public class ButtonFactory extends JButton{

	public ButtonFactory(@Nullable String text,@Nullable Color bgColor, @Nullable Color fgColor) {
		setOpaque(true);
		setBackground(bgColor);
		if(fgColor != null) {
			setForeground(fgColor);
		}
		setForeground(Colors.White);
		setText(text);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setBorderPainted(true);
		setBorder(null);
		setContentAreaFilled(false);
	}
}
