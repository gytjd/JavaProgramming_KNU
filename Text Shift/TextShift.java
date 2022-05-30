//2020117898 황효

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TextShift extends JFrame {
	
	private JTextField field=new JTextField("I Love Java Programming!"); // 초기 JTextField 의 값은 "I Love Java Programming!"로 설정함
	private JLabel centerLabel=new JLabel("I Love Java Programming!");
	private JLabel botoomLabel=new JLabel("Key Pressed:");
	
	public TextShift() {
		
		setTitle("움직이는 텍스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.addKeyListener(new MykeyListener());
		

		field.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JTextField temp=(JTextField)e.getSource();
				centerLabel.setText(temp.getText());
				
				c.setFocusable(true); // focus 가 화면 가운데 JLabel 로 넘어가도록 구현
				c.requestFocus();
			}
		}); // JTextField 에서 텍스트를 변경하고 Enter 키를 누르면 화면 가운데 JLabel 에도 변경된 텍스트가 반영
		
		
		centerLabel.setFont(new Font("TimesRoman",Font.PLAIN,30));
		centerLabel.setForeground(Color.BLACK);
		centerLabel.addKeyListener(new MykeyListener());
		centerLabel.setHorizontalAlignment(JLabel.CENTER);
		// 초기 폰트 크기는 아래와 같이 30 으로 지정하고 폰트 종류는 임의로 선정함
		
		botoomLabel.setHorizontalAlignment(JLabel.CENTER);
		
		
		c.setLayout(new BorderLayout());
		c.add(centerLabel,BorderLayout.CENTER);
		c.add(field,BorderLayout.NORTH);
		c.add(botoomLabel,BorderLayout.SOUTH);
		
		
		setSize(500,300);
		// 프레임의 크기는 (500, 300)이고 레이아웃은 BorderLayout 사용
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	
	
	
	class MykeyListener extends KeyAdapter {
		
		
		public void keyPressed(KeyEvent e)
		{				
			botoomLabel.setText("KeyEvent:"+KeyEvent.getKeyText(e.getKeyCode())+" pressed");
			// 화면 하단에 입력된 키의 값을 출력하는 JLabel을 생성하고 입력된 Keytext를 출력함 (1점)
			
			String s=centerLabel.getText();
			
			if(e.getKeyChar()=='r') //  ‘r’: 폰트 색상 변경 (Red)
			{	
				centerLabel.setForeground(Color.RED);
			}
			else if(e.getKeyChar()=='g') // ‘g’: 폰트 색상 변경 (Green):
			{
				centerLabel.setForeground(Color.GREEN);	
			}
			else if(e.getKeyChar()=='b') // ‘b’: 폰트 색상 변경 (Blue)
			{
				centerLabel.setForeground(Color.BLUE);
			}
			else if(e.getKeyCode()==KeyEvent.VK_LEFT) // 왼쪽 화살표 (VK_LEFT): 한글자씩 왼쪽으로 이동
			{
				centerLabel.setText(s.substring(1)+s.substring(0,1)); // 맨 왼쪽의 글자는 맨 오른쪽에 위치함 (문자열 처리 방식 이용)
			}
			else if(e.getKeyCode()==KeyEvent.VK_RIGHT) // 오른쪽 화살표 (VK_RIGHT): 한글자씩 오른쪽으로 이동
			{
				centerLabel.setText(s.substring(s.length()-1)+s.substring(0,s.length()-1));	// 맨 오른쪽의 글자는 맨 왼쪽에 위치함
			}
			else // 그 외 키 입력: 폰트 색상 변경 (Black) 
			{	
				centerLabel.setForeground(Color.BLACK);
			}
		
		}
		
	}
	


	public static void main(String[] args) {
		new TextShift();
	}

}
