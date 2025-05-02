/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editTable;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableStyleUtil {

    public static void applyTableStyle(JTable table) {
        // Font và chiều cao hàng
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(28);

        // Căn giữa tiêu đề cột
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer())
            .setHorizontalAlignment(SwingConstants.CENTER);

        // Font tiêu đề cột
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        table.getTableHeader().setPreferredSize(new Dimension(100, 40));

        // Căn giữa nội dung các cột
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Màu nền xen kẽ cho từng dòng
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable tbl, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(tbl, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? new Color(245, 245, 245) : Color.WHITE);
                } else {
                    c.setBackground(new Color(184, 207, 229)); // màu khi chọn
                }
                return c;
            }
        });
    }
    
}

