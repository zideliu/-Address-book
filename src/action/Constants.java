package action;

import java.awt.*;

public class Constants {


	public static String CHECK_NUMBER_NAME="message";
	//public static final int IMAGE_WIDTH =120;
    // 验证码的字体库
	protected static Font[] codeFont = { new Font("Times New Roman", Font.PLAIN, 30),
			new Font("Times New Roman", Font.PLAIN, 30), new Font("Times New Roman", Font.PLAIN, 30),
			new Font("Times New Roman", Font.PLAIN, 30) };

	// 验证码数字颜色库
	protected static Color[] color = { Color.BLACK, Color.RED, Color.DARK_GRAY, Color.BLUE };

	// 验证码的字符库
	protected static final String IMAGE_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	// 验证码的宽度
    static final Integer IMAGE_WIDTH = 120;

	// 验证码的高度
    static final Integer IMAGE_HEIGHT = 40;
}
