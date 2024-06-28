import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

// Code by engineer nyaigotti
public class gui {

    public static void main(String[] args) {

        JFrame jframe = new JFrame("Pet App Nyaigotti");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(300, 200);

        // Create radio buttons with labels
        String birdString = "Bird";
        String catString = "Cat";
        String dogString = "Dog";
        String rabbitString = "Rabbit";
        String pigString = "Pig";
        
        JRadioButton birdButton = new JRadioButton(birdString);
        JRadioButton catButton = new JRadioButton(catString);
        JRadioButton dogButton = new JRadioButton(dogString);
        JRadioButton rabbitButton = new JRadioButton(rabbitString);
        JRadioButton pigButton = new JRadioButton(pigString);

        // Group the radio buttons to ensure only one can be selected at a time
        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        // Create a panel ya kuhold the radio buttons
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);
        radioPanel.setPreferredSize(new Dimension(100, 250)); // Set preferred size

        // Create a panel ya ku hold the image
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS)); // Use BoxLayout to arrange components
        imagePanel.setPreferredSize(new Dimension(250, 250)); // Ensure the size is appropriate

        // Load default image and set to label
        JLabel imageLabel = new JLabel();
        imageLabel.setBorder(new EmptyBorder(20, 0, 0, 0)); // Add padding to the top side
        updateImage(imageLabel, "bird.png");
        imagePanel.add(imageLabel);

        // Add listeners to radio buttons to update image
        birdButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateImage(imageLabel, "bird.png");
            }
        });

        catButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateImage(imageLabel, "cat.png");
            }
        });

        dogButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateImage(imageLabel, "dog.png");
            }
        });

        rabbitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateImage(imageLabel, "rabbit.png");
            }
        });

        pigButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateImage(imageLabel, "pig.png");
            }
        });

        // Create a container panel ya kuhold the radioPanel and imagePanel
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new GridLayout(1, 2, 5, 5)); // Use GridLayout for side-by-side panels with spacing
        containerPanel.add(radioPanel);
        containerPanel.add(imagePanel);

        // Add the container panel kwa the frame
        jframe.add(containerPanel);

        jframe.setVisible(true);
    }

    private static void updateImage(JLabel label, String imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage(); // Transform it
        Image newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // Scale it to desired size
        imageIcon = new ImageIcon(newimg);  // Transform it back
        label.setIcon(imageIcon);
    }
}
