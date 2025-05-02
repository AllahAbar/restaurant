package editTable;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class editPaneTab {

    public static void applyCustomStyle(JTabbedPane tabbedPane) {
        tabbedPane.setUI(new BasicTabbedPaneUI() {

            @Override
            protected Insets getTabInsets(int tabPlacement, int tabIndex) {
                // Tạo lề bên trong cho từng tab (top, left, bottom, right)
                return new Insets(10, 20, 10, 20);
            }

            @Override
            protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
                return super.calculateTabWidth(tabPlacement, tabIndex, metrics) + 10;
            }

            @Override
            protected void installDefaults() {
                super.installDefaults();
                tabAreaInsets = new Insets(5, 10, 5, 10); // lề vùng chứa tab
            }

            @Override
            protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex,
                                              int x, int y, int w, int h, boolean isSelected) {
                g.setColor(isSelected ? new Color(180, 205, 230) : new Color(220, 220, 220));
                g.fillRoundRect(x, y + 2, w, h - 4, 10, 10);
            }

            @Override
            protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects,
                                               int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
                // Không vẽ viền focus
            }
        });
    }
    
    public static void customizeTabbedPane(JTabbedPane tabbedPane) {
        tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 14));
        tabbedPane.setForeground(Color.DARK_GRAY);
        tabbedPane.setBackground(new Color(240, 240, 240));
        tabbedPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Thay đổi màu tab được chọn bằng UIManager (toàn cục)
        UIManager.put("TabbedPane.selected", new Color(214, 234, 248));
        UIManager.put("TabbedPane.tabInsets", new Insets(10, 20, 10, 20));
    }
}
