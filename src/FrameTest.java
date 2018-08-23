
//package Swing;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * 
 * @author Liuheng 基本框架
 */
public class FrameTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 开启一个线程，所有的Swing组件必须由事件分派线程进行配置，线程将鼠标点击和按键控制转移到用户接口组件。
		EventQueue.invokeLater(new Runnable() {
			// 匿名内部类，是一个Runnable接口的实例，实现了run方法
			public void run() {

				SimpleFrame frame = new SimpleFrame();
				// 创建下面自己定义的SimpleFrame类对象，以便于调用构造器方法

				frame.setExtendedState(Frame.MAXIMIZED_BOTH);
				// 将窗口最大化
				// 其他可选属性：Frame.NORMAL ICONIFIED MAXIMIZED_HORIZ MAXIMIZED_VERT
				// MAXIMIZED_BOTH

				frame.setTitle("Swing Test");
				// 设置窗口标题

				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// 选择当用户关闭框架时进行的操作 ，在有些时候需要将窗口隐藏，不能直接退出需要用到这个方法

				frame.setVisible(true);
				// 将窗口可见化，这样以便用户在第一次看见窗口之前我们能够向其中添加内容
			}

		});
	}
	// main结束时，程序并没有结束，而是结束了主线程，知道所有框架关闭或者调用了 System.exit事才终止程序
}

class SimpleFrame extends JFrame {
	public SimpleFrame() {

		// 向其中添加一个实例化的实现JComponent类的子类
		add(new DrawTestComponent());

		// 调用框架组件的首选大小，或者我们可以用SetSize方法来替换它
		pack();

		/*
		 * Toolkit kit = Toolkit.getDefaultToolkit(); // 修改窗口在屏幕上面的位置，改变窗口大小 //
		 * Toolkit类包含很多与本地窗口交互的方法
		 * 
		 * Dimension screenSize = kit.getScreenSize(); //
		 * Toolkit的获取频幕大小的方法返回一个Dimension的类对象
		 * 
		 * setSize((int) (screenSize.getWidth()), (int) (screenSize.getHeight())); //
		 * setBounds(0,0,(int)(screenSize.getWidth()),(int)(screenSize.getHeight())); //
		 * 定义窗口的位置和大小 // setLocation(0,0); 定位窗口距离左上角的位置 // setLocationByPlatform(true);
		 * 让窗口系统控制窗口位置，距离上一个窗口很小的偏移量
		 * 
		 * // 用图片来替换窗口图标 Image img = new ImageIcon("D:/icon.png").getImage();
		 * setIconImage(img);
		 * 
		 */
	}
}

class HelloWorldComponent extends JComponent {
	private static final int MESSAGE_X = 60;
	private static final int MESSAGE_Y = 110;

	public void paintComponent(Graphics g) {
		g.drawString("Hello World", MESSAGE_X, MESSAGE_Y);
	}
}

class DrawTestComponent extends JComponent {
	private static final int DEFAULT_WIDE = 500;
	private static final int DEFAULT_HIGH = 500;

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		double leftX = 200;
		double topY = 200;
		double width = 200;
		double higth = 200;

		// 绘制矩形
		g2.draw(new Rectangle2D.Double(leftX, topY, width, higth));

		// 绘制椭圆
		g2.draw(new Ellipse2D.Double(leftX, topY, width, higth));

		// 绘制直线
		g2.draw(new Line2D.Double(leftX, topY, width + leftX, higth + topY));
		// g2.draw(new Line2D.Double(100, 200, 100, 0));
	}

	// 返回一个Dimension对象,表示这个组件的大小
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDE, DEFAULT_HIGH);
	}
}