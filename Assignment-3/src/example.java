import java.awt.Color;

import javax.swing.JCheckBox;

public class example {

	public static void main(String[] args) {
		// Create new image utility
		ImageUtils utils = new ImageUtils();
        
		//load in an image
		Color[][] orig = utils.loadImage("src/LennaCV.png");
		
		// Add original image tab
		utils.addImage(orig, "Original image.");
		
		// Process the image.
		Color[][] halfBlack = process(orig);
		utils.addImage(halfBlack, "Greyscale image");
		
		Color [][] randomEffect = random();
		utils.addImage(randomEffect, "Grain-y image");
		
		Color[][] negative = negativeImage(orig);
		utils.addImage(negative, "Negative image");
		
		Color[][] redColor = redImage(orig);
		utils.addImage(redColor, "Red image");
		
		Color[][] sepia = sepia(orig);
		utils.addImage(sepia, "Sepia image");

		utils.display();
	}
	
	public static Color[][] process(Color[][] img) {
		Color[][] tmp = ImageUtils.cloneArray(img);
		
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++)	{
				if (i < tmp.length) {
					// Red, Green, Blue: 0-255
					//tmp[i][j] = new Color(0,0,0);
					Color pixel = tmp[i][j];
					int r = pixel.getRed(); // gets red value
					int g = pixel.getGreen();
					int b = pixel.getBlue();
					int avg = (r+g+b)/3;
					tmp[i][j] = new Color(avg,avg,avg);
				} // if statement
			} // for j loop (column)
		} // for i loop (row)
		return tmp;
	}
	
	public static Color[][] negativeImage(Color[][] img) {
		Color[][] tmp = ImageUtils.cloneArray(img);
		
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++)	{
				if (i < tmp.length) {
					// Red, Green, Blue: 0-255
					Color pixel = tmp[i][j];
					int r = 255-pixel.getRed(); // gets red value
					int g = 255-pixel.getGreen();
					int b = 255-pixel.getBlue();
					tmp[i][j] = new Color(r,g,b);
				} // if statement
			} // for j loop (column)
		} // for i loop (row)
		return tmp;
	} // negativeImage
	
	public static Color[][] redImage(Color[][] img) {
		Color[][] tmp = ImageUtils.cloneArray(img);
		
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++)	{
				if (i < tmp.length) {
					// Red, Green, Blue: 0-255
					Color pixel = tmp[i][j];
					int r = pixel.getRed(); // gets red value
					int g = 0;
					int b = 0;
					tmp[i][j] = new Color(r,g,b);
				} // if statement
			} // for j loop (column)
		} // for i loop (row)
		return tmp;
	} // redImage
	
	public static Color[][] sepia(Color[][] img) {
		Color[][] tmp = ImageUtils.cloneArray(img);
		
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++)	{
				if (i < tmp.length) {
					// Red, Green, Blue: 0-255
					Color pixel = tmp[i][j];
					int r = pixel.getRed(); // gets red value
					int g = pixel.getGreen();
					int b = pixel.getBlue();
					//calculate newRed, newGreen, newBlue
	                int newRed = (int)(0.393*r + 0.769*g + 0.189*b);
	                int newGreen = (int)(0.349*r + 0.686*g + 0.168*b);
	                int newBlue = (int)(0.272*r + 0.534*g + 0.131*b);
	                // check condition
	                if (newRed>255)
	                	r = 255;
	                else
	                	r = newRed;
	                if (newGreen>255)
	                	g=255;
	                else
	                	g = newGreen;
	                if (newBlue>255)
	                	b = 255;
	                else
	                	b = newBlue;
					tmp[i][j] = new Color(r,g,b);
				} // if statement
			} // for j loop (column)
		} // for i loop (row)
		return tmp;
	} // sepia

	public static Color[][] random() {
		ImageUtils utils = new ImageUtils();
		Color[][] tmp = utils.loadImage("src/LennaCV.png");
		utils.addImage(tmp, "ish");
		utils.display();
			
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++)	{
				if (i < tmp.length) {
					// Red, Green, Blue: 0-255
					Color pixel = tmp[i][j];
					int r = (int) (pixel.getRed()*Math.random()); 
					int g = (int) (pixel.getGreen()*Math.random());
					int b = (int) (pixel.getBlue()*Math.random());
					tmp[i][j] = new Color(r,g,b);
				} // if statement
			} // for j loop (column)
		} // for i loop (row)
		return tmp;
	} // sepia
}
