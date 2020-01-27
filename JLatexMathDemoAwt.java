package project.hackathon.src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;


public class JLatexMathDemoAwt extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel instruction;
	private JTextArea latexInput;
	private JPanel displayArea;
	private static String LatexExpression = "";
	private String fractionMessage = "Kindly enter Numerator and Denominator by space seperation.";

	public JLatexMathDemoAwt() {
		this.setTitle("JLatexMath Demo Awt");
		this.setSize(800, 800);
		Container content = this.getContentPane();
		content.setLayout(new GridLayout(3, 1));
		this.instruction = new JLabel("\"Kindly press the key combinaton to convert your expression e.g. alt+f for fraction.\"");
		Font labelFont = new Font("Serif",Font.BOLD, 20);
		instruction.setFont(labelFont);
		this.latexInput = new JTextArea();
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(this.instruction, BorderLayout.NORTH);
		panel.add(new JScrollPane(this.latexInput),BorderLayout.CENTER);
		
		content.add(panel);
		content.add(this.displayArea = new JPanel());		
	    registerKeyListners();
	}
	public void registerKeyListners() {
		
		this.latexInput.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.isAltDown() && e.getKeyChar() == 'f') {
			        LatexExpression = "Fraction";
					latexInput.setText(fractionMessage);
				}
				if(e.getKeyCode() == e.VK_ENTER) {
					String text = latexInput.getText();
					switch (LatexExpression) {
						case "Fraction":
							text = text.replace(fractionMessage, "");
							String[] input = text.split(" ");
							if (input.length == 2) {
								String expression = "$\\displaystyle \\frac{" + input[0] + "}{" + input[1] + "}$";
								String label = input[0] +" divided by " + input[1];
								render(expression, label);
							}
							latexInput.setText("");
						default:
					}
					LatexExpression = "";
				}
			}
		});
	}
	
	public void render(String latex, String label) {
		try {
			// create a formula
			TeXFormula formula = new TeXFormula(latex);
			
			// render the formla to an icon of the same size as the formula.
			TeXIcon icon = formula
					.createTeXIcon(TeXConstants.STYLE_DISPLAY, 20);
			
			
			// insert a border 
			icon.setInsets(new Insets(5, 5, 5, 5));

			// now create an actual image of the rendered equation
			BufferedImage image = new BufferedImage(icon.getIconWidth(),
					icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = image.createGraphics();
			g2.setColor(Color.white);
			g2.fillRect(0, 0, icon.getIconWidth(), icon.getIconHeight());
			JLabel jl = new JLabel();
			jl.setText(label);
			jl.setForeground(new Color(0, 0, 0));
			icon.paintIcon(jl, g2, 0, 0);
			// at this point the image is created, you could also save it with ImageIO
			
			// now draw it to the screen			
			Graphics g = this.displayArea.getGraphics();
			g.drawImage(image,0,0,null);
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
					JOptionPane.INFORMATION_MESSAGE);		
		}
	}

	public static void main(String[] args) {
		JLatexMathDemoAwt frame = new JLatexMathDemoAwt();		
		frame.setVisible(true);
	}
}
