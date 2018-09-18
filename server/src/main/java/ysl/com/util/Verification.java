package ysl.com.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Verification {
	//图形验证码的字符集，系统将随机从这个字符串中选择一些字符作为验证码
	private static String codeChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public String match(String Code){
		int length = codeChars.length();
		int width=90;
		int height=30;
		BufferedImage bufferedImage=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphics=bufferedImage.getGraphics();
		Random random=new Random();
		graphics.setColor(getRandomColor(180, 250));
		graphics.fillRect(0, 0, width, height);
		graphics.setFont(new Font("Times New Roman", Font.ITALIC, height));
		graphics.setColor(getRandomColor(120, 180));
		//用户保存最后随机生成的验证码
		StringBuffer VerificationCode=new StringBuffer();
		String[] fontNames={ "Times New Roman", "Book antiqua", "Arial"};
		//随机生成4个验证码
		for(int i=0;i<4;i++){
			graphics.setFont(new Font(fontNames[random.nextInt(3)], Font.ITALIC, height));
			//随机获得当前验证码的字符
			char codeChar = codeChars.charAt(random.nextInt(length));
			//随机获得当前验证码的字符
			VerificationCode.append(codeChar);
			//随机设置当前验证码字符的颜色
			graphics.setColor(getRandomColor(10, 100));
			//在图形上输出验证码字符，x和y都是随机生成
			graphics.drawString(String.valueOf(codeChar), 16*i+random.nextInt(7), height-random.nextInt(6));
		}
		return null;
		
	}
	private Color getRandomColor(int minColor, int maxColor) {
		            Random random = new Random();
		              if(minColor > 255){
		                  minColor = 255;
		              }
		              if(maxColor > 255){
		                  maxColor = 255;
		              }
		              //获得r的随机颜色值
		              int red = minColor+random.nextInt(maxColor-minColor);
		              int green = minColor + random.nextInt(maxColor-minColor);
		             int blue = minColor + random.nextInt(maxColor-minColor);
		             return new Color(red,green,blue);
		     }
	
}
