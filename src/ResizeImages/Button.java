package ResizeImages;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author PC
 */
public class Button {
    public static void setScaledIcon(JButton button, String imagePath) {
        // Sử dụng getClass().getResource để lấy hình ảnh từ tài nguyên với đường dẫn tương đối
        ImageIcon icon = new ImageIcon(Button.class.getResource(imagePath));

        int width = button.getWidth();
        int height = button.getHeight();

        if (width == 0 || height == 0) {
            button.addComponentListener(new java.awt.event.ComponentAdapter() {
                @Override
                public void componentResized(java.awt.event.ComponentEvent e) {
                    applyHighQualityIcon(button, icon, button.getWidth(), button.getHeight());
                }
            });
        } else {
            applyHighQualityIcon(button, icon, width, height);
        }
    }

    private static void applyHighQualityIcon(JButton button, ImageIcon icon, int width, int height) {
        Image original = icon.getImage();
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();

        // Bật anti-aliasing và rendering quality cao
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawImage(original, 0, 0, width, height, null);
        g2d.dispose();

        button.setIcon(new ImageIcon(resized));
    }
}
