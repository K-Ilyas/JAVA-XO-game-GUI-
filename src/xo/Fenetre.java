  package xo;
  import java.awt.BorderLayout;
  import java.awt.Color;
  import java.awt.GridLayout;
  import java.awt.event.ActionEvent;
  import java.awt.event.ActionListener;
  import java.security.MessageDigest;
  import javax.swing.*;


    public class Fenetre extends  JFrame implements ActionListener{
	private boolean x=false;
    private boolean o=false;
    private  ButtonGroup gr=new ButtonGroup();
	private JRadioButton X=new JRadioButton("X");		
	private JRadioButton O=new JRadioButton("O");
	private JButton B1;
	private JButton B2;
	private JButton B3;
	private JButton B4;
	private JButton B5;
	private JButton B6;
	private JButton B7;
	private JButton B8;
	private JButton B9;
	private char[][]  tableau;
	private JButton reset =new JButton("reset");;
	private JButton  recommence=new JButton("recommence");
	private JButton quite=new JButton("quite");
	
	JMenuBar menu=new JMenuBar();
	JMenu m1=new JMenu("fichier");
	JMenuItem item1=new JMenuItem("reset");
	JMenuItem item2=new JMenuItem("recommencer");
	JMenuItem item3=new JMenuItem("quiter");
	


    class result
    {
    	String type;
    	int position;
    	public String Type()
    	{
    		return type;
    	}
    	public int pos()
    	{
    		return position;
    	}
    	public result(String type,int position)
    	{
    		this.type=type;
    		this.position=position;
    	}
    }
	public Fenetre()
	{ 
		
		
		item3.addActionListener(this);
		menu.add(m1);
		
		item1.addActionListener(new restart());
		m1.add(item1);
		m1.add(item2);
		item2.setEnabled(false);
		item2.addActionListener(new recommecner());
		m1.add(item3);
		this.setJMenuBar(menu);
		
		this.tableau=new char[3][3];
		
		this.setSize(400, 200);
		B1=new JButton("");
		B2=new JButton("");
		B3=new JButton("");
		B4=new JButton("");
		B5=new JButton("");
		B6=new JButton("");
		B7=new JButton("");
		B8=new JButton("");
		B9=new JButton("");
		 
		 B1.addActionListener(new actionB1());
		 B2.addActionListener(new actionB2());
		 B3.addActionListener(new actionB3());
		 B4.addActionListener(new actionB4());
		 B5.addActionListener(new actionB5());
		 B6.addActionListener(new actionB6());
		 B7.addActionListener(new actionB7());
		 B8.addActionListener(new actionB8());
		 B9.addActionListener(new actionB9());
		 
		JFrame fenetre=new JFrame();
		JPanel principale=new JPanel();
		JPanel panel1=new JPanel();
		JPanel panel2=new JPanel();
		JPanel panel3=new JPanel();
		JPanel panel4=new JPanel();
		JPanel group=new JPanel();
		
		B1.addActionListener(this);
	    
		reset.addActionListener(new restart());
		gr.add(X);
		gr.add(O);
		
		X.addActionListener(this);
		O.addActionListener(this);
		
	
		
		quite.setSize(40,20);
	   recommence.setEnabled(false);
	   recommence.addActionListener(new recommecner());
	   quite.addActionListener(this);
	    GridLayout grid3=new GridLayout(1,2);

	 panel1.setLayout(new GridLayout(3,3));
	 
	 panel1.add(B1);
	 panel1.add(B2);
	 panel1.add(B3);
	 panel1.add(B4);
	 panel1.add(B5);
	 panel1.add(B6);
	 panel1.add(B6);
	 panel1.add(B7);
	 panel1.add(B8);
	 panel1.add(B9);
	 
	    B1.setBackground(Color.CYAN);
		B2.setBackground(Color.CYAN);
		B3.setBackground(Color.CYAN);
		B4.setBackground(Color.CYAN);
		B5.setBackground(Color.CYAN);
		B6.setBackground(Color.CYAN);
		B7.setBackground(Color.CYAN);
		B8.setBackground(Color.CYAN);
		B9.setBackground(Color.CYAN);
	  
	 panel2.setLayout(new GridLayout(3,1));
	 panel2.add(reset);
	 panel2.add(recommence);
	 panel2.add(quite);
	 panel3.add(X);
	 panel3.add(O);
	 group.setLayout(new GridLayout(1,2));
	
	 group.add(panel1);
	 group.add(panel2);
	 
	 this.setTitle("ma fénetre");
	 this.setLocationRelativeTo(null);
	 
	 principale.setLayout(new BoxLayout(principale, BoxLayout.PAGE_AXIS));
	 principale.add(group);
	 principale.add(panel3);
	 
	 this.getContentPane().add(principale);
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==X)
		{
			x=true;
			o=false;
			X.setEnabled(false);
			O.setEnabled(false);
		}
		else if(e.getSource()==O)
		{
			x=false;
			o=true;
			X.setEnabled(false);
			O.setEnabled(false);
		}
		else if(e.getSource()==quite)
		{
			System.exit(0);
		}
		else if(e.getSource()==item3)
		{
			System.exit(0);
		}
		
	}
	public void disabled()
	{
		B1.setEnabled(false);
		B2.setEnabled(false);
		B3.setEnabled(false);
		B4.setEnabled(false);
		B5.setEnabled(false);
		B6.setEnabled(false);
		B7.setEnabled(false);
		B8.setEnabled(false);
		B9.setEnabled(false);
	}
	public boolean isEnable()
	{
		return (!B1.isEnabled() &&  !B2.isEnabled() &&!B3.isEnabled() &&!B4.isEnabled() &&!B5.isEnabled() && !B6.isEnabled() &&!B7.isEnabled() &&!B8.isEnabled() && !B9.isEnabled())?true:false;
	}
	
	public void correction()
	{
		
		result res=verifier();
		if(res!=null)
		{
		if(res.Type()=="row")
		{
			if(res.pos()==1)
			{
				B1.setBackground(Color.RED);
				B2.setBackground(Color.RED);
				B3.setBackground(Color.RED);
			}
			else if(res.pos()==2)
			{
				B4.setBackground(Color.RED);
				B5.setBackground(Color.RED);
				B6.setBackground(Color.RED);
			}
			else if(res.pos()==3)
			{
				B7.setBackground(Color.RED);
				B8.setBackground(Color.RED);
				B9.setBackground(Color.RED);
			}
			disabled();
			   recommence.setEnabled(true);
			   item2.setEnabled(true);

		}
		else if(res.Type()=="col")
		{
			if(res.pos()==1)
			{
				B1.setBackground(Color.RED);
				B4.setBackground(Color.RED);
				B7.setBackground(Color.RED);
			}
			else if(res.pos()==2)
			{
				B2.setBackground(Color.RED);
				B5.setBackground(Color.RED);
				B8.setBackground(Color.RED);
			}
			else if(res.pos()==3)
			{
				B3.setBackground(Color.RED);
				B6.setBackground(Color.RED);
				B9.setBackground(Color.RED);
			}
			disabled();
			   recommence.setEnabled(true);
			   item2.setEnabled(true);


		}
		else if(res.Type()=="center")
		{
			if(res.pos()==123)
			{
				B1.setBackground(Color.RED);
				B5.setBackground(Color.RED);
				B9.setBackground(Color.RED);
			}
			else if(res.pos()==321)
			{
				B3.setBackground(Color.RED);
				B5.setBackground(Color.RED);
				B7.setBackground(Color.RED);
			}
			disabled();
			   recommence.setEnabled(true);
			   item2.setEnabled(true);


		}
		
		}
		else
		{
			if(isEnable())
			{
        		JOptionPane.showMessageDialog(null,"no Winner");
 			    recommence.setEnabled(true);
			    item2.setEnabled(true);


			}

		}
		
	}
	
	class actionB1 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
	        	 if(x || o)
		     		{
		        		 B1.setText((x)?X.getText():O.getText());
		        		 B1.setEnabled(false);
		        		 tableau[0][0]=(x)?X.getText().charAt(0):O.getText().charAt(0);
		        		 x=!x;
		        		 o=!o;
		        		 correction();
		        		 mouve();
		     		}
	         
		}
		
	}
	class actionB2 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
	        	 if(x || o)
		     		{
		        		 B2.setText((x)?X.getText():O.getText());
		        		 B2.setEnabled(false);
		        		 tableau[0][1]=(x)?X.getText().charAt(0):O.getText().charAt(0);
		        		 x=!x;
		        		 o=!o;
		        		 correction();
		        		 mouve();

		     		}
	         
		}
		
	}
	class actionB3 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
	        	 if(x || o)
		     		{
		        		 B3.setText((x)?X.getText():O.getText());
		        		 B3.setEnabled(false);
		        		 tableau[0][2]=(x)?X.getText().charAt(0):O.getText().charAt(0);
		        		 x=!x;
		        		 o=!o;
		        		 correction();
		        		 mouve();

		     		}
	         
		}
		
	}
	class actionB4 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
	        	 if(x || o)
		     		{
		        		 B4.setText((x)?X.getText():O.getText());
		        		 B4.setEnabled(false);
		        		 tableau[1][0]=(x)?X.getText().charAt(0):O.getText().charAt(0);
		        		 x=!x;
		        		 o=!o;
		        		 correction();
		        		 mouve();

		     		}
	         
		}
		
	}
	class actionB5 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
	        	 if(x || o)
		     		{
		        		 B5.setText((x)?X.getText():O.getText());
		        		 B5.setEnabled(false);
		        		 tableau[1][1]=(x)?X.getText().charAt(0):O.getText().charAt(0);
		        		 x=!x;
		        		 o=!o;
		        		 correction();
		        		 mouve();


		     		}
	         
		}
		
	}
	class actionB6 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
	        	 if(x || o)
		     		{
		        		 B6.setText((x)?X.getText():O.getText());
		        		 B6.setEnabled(false);
		        		 tableau[1][2]=(x)?X.getText().charAt(0):O.getText().charAt(0);
		        		 x=!x;
		        		 o=!o;
		        		 correction();
		        		 mouve();


		     		}
	         
		}
		
	}
	class actionB7 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
	        	 if(x || o)
		     		{
		        		 B7.setText((x)?X.getText():O.getText());
		        		 B7.setEnabled(false);
		        		 tableau[2][0]=(x)?X.getText().charAt(0):O.getText().charAt(0);
		        		 x=!x;
		        		 o=!o;
		        		 correction();
		        		 mouve();


		     		}
	         
		}
		
	}
	class actionB8 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
	        	 if(x || o)
		     		{
		        		 B8.setText((x)?X.getText():O.getText());
		        		 B8.setEnabled(false);
		        		 tableau[2][1]=(x)?X.getText().charAt(0):O.getText().charAt(0);
		        		 x=!x;
		        		 o=!o;
		        		 correction();
		        		 mouve();

		     		}
	         
		}
		
	}
	class recommecner implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
	        	if(x==false && o==false)
	        	{
			B1.setEnabled(true);
			B2.setEnabled(true);
			B3.setEnabled(true);
			B4.setEnabled(true);
			B5.setEnabled(true);
			B6.setEnabled(true);
			B7.setEnabled(true);
			B8.setEnabled(true);
			B9.setEnabled(true);
			B1.setText("");
			B2.setText("");
			B3.setText("");
			B4.setText("");
			B5.setText("");
			B6.setText("");
			B7.setText("");
			B8.setText("");
			B9.setText("");
			
			B1.setBackground(Color.CYAN);
			B2.setBackground(Color.CYAN);
			B3.setBackground(Color.CYAN);
			B4.setBackground(Color.CYAN);
			B5.setBackground(Color.CYAN);
			B6.setBackground(Color.CYAN);
			B7.setBackground(Color.CYAN);
			B8.setBackground(Color.CYAN);
			B9.setBackground(Color.CYAN);
			x=false;
			o=false;
			X.setEnabled(true);
			O.setEnabled(true);
			X.setSelected(false);
			O.setSelected(false);
			gr.clearSelection();

			
			
			for(int i=0;i<tableau.length;i++)
			{
				for(int j=0;j<3;j++)
				{
					tableau[i][j]=' ';
				}
			}
			
	        	}
	        	else if(isEnable())
	        	{
	        		B1.setEnabled(true);
	    			B2.setEnabled(true);
	    			B3.setEnabled(true);
	    			B4.setEnabled(true);
	    			B5.setEnabled(true);
	    			B6.setEnabled(true);
	    			B7.setEnabled(true);
	    			B8.setEnabled(true);
	    			B9.setEnabled(true);
	    			B1.setText("");
	    			B2.setText("");
	    			B3.setText("");
	    			B4.setText("");
	    			B5.setText("");
	    			B6.setText("");
	    			B7.setText("");
	    			B8.setText("");
	    			B9.setText("");
	    			
	    			B1.setBackground(Color.CYAN);
	    			B2.setBackground(Color.CYAN);
	    			B3.setBackground(Color.CYAN);
	    			B4.setBackground(Color.CYAN);
	    			B5.setBackground(Color.CYAN);
	    			B6.setBackground(Color.CYAN);
	    			B7.setBackground(Color.CYAN);
	    			B8.setBackground(Color.CYAN);
	    			B9.setBackground(Color.CYAN);
	    			x=false;
	    			o=false;
	    			X.setEnabled(true);
	    			O.setEnabled(true);
	    			X.setSelected(false);
	    			O.setSelected(false);
	    			gr.clearSelection();
	    			for(int i=0;i<tableau.length;i++)
	    			{
	    				for(int j=0;j<3;j++)
	    				{
	    					tableau[i][j]=' ';
	    				}
	    			}
	        		
	        	}
	        	else
	        	{
	        		JOptionPane.showMessageDialog(null,"vous n'avez pas le droit peendant le jeux");
	        	}
		}
		
	}
	
	class restart implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			B1.setEnabled(true);
			B2.setEnabled(true);
			B3.setEnabled(true);
			B4.setEnabled(true);
			B5.setEnabled(true);
			B6.setEnabled(true);
			B7.setEnabled(true);
			B8.setEnabled(true);
			B9.setEnabled(true);
			B1.setText("");
			B2.setText("");
			B3.setText("");
			B4.setText("");
			B5.setText("");
			B6.setText("");
			B7.setText("");
			B8.setText("");
			B9.setText("");
			
			B1.setBackground(Color.CYAN);
			B2.setBackground(Color.CYAN);
			B3.setBackground(Color.CYAN);
			B4.setBackground(Color.CYAN);
			B5.setBackground(Color.CYAN);
			B6.setBackground(Color.CYAN);
			B7.setBackground(Color.CYAN);
			B8.setBackground(Color.CYAN);
			B9.setBackground(Color.CYAN);
			x=false;
			o=false;
			X.setEnabled(true);
			O.setEnabled(true);
			X.setSelected(false);
			O.setSelected(false);
			gr.clearSelection();

			
			
			for(int i=0;i<tableau.length;i++)
			{
				for(int j=0;j<3;j++)
				{
					tableau[i][j]=' ';
				}
			}			
		}
		
	}
	
	class actionB9 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
	        	 if(x || o)
		     		{
		        		 B9.setText((x)?X.getText():O.getText());
		        		 B9.setEnabled(false);
		        		 tableau[2][2]=(x)?X.getText().charAt(0):O.getText().charAt(0);
		        		 x=!x;
		        		 o=!o;
		        		 correction();
		        		 mouve();
		     		}
	         
		}
		
	}
	public void mouve()
	{
		if(x)
		{
			X.setSelected(true);
			
		}
		else if(o)
		{
			O.setSelected(true);

		}
		else
		{
		 O.setSelected(false);
		 X.setSelected(false);
		}
	}
	public result verifier()
	{ 
		
		char x1='X',o1='O';
		if(!X.isEnabled() && !O.isEnabled())
		{			            
			
			
	         for(int i=0;i<tableau.length;i++)
	         {
	        	if((tableau[i][0]==x1 && tableau[i][1]==x1 && tableau[i][2]==x1) ||(tableau[i][0]==o1 && tableau[i][1]==o1 && tableau[i][2]==o1)  )
	        	{
	        		
	        		x=false;
	        		o=false;
	        		JOptionPane.showMessageDialog(null, tableau[i][0]+" gange");
	        		return new result("row",i+1);
	        	
	        	}
	        	if((tableau[0][i]==x1 && tableau[1][i]==x1 && tableau[2][i]==x1) ||(tableau[0][i]==o1 && tableau[1][i]==o1 && tableau[2][i]==o1)  )
	        	{
	        		x=false;
	        		o=false;
	        		
	        		JOptionPane.showMessageDialog(null, tableau[0][i]+" gange");
	        		return new result("col",i+1);
	        	
	        	}
	        	if((tableau[0][0]==x1 && tableau[1][1]==x1 && tableau[2][2]==x1) ||(tableau[0][0]==o1 && tableau[1][1]==o1 && tableau[2][2]==o1)  )
	        	{
	        		x=false;
	        		o=false;
	        		JOptionPane.showMessageDialog(null, tableau[0][0]+" gange");
	        		return new result("center",123);
	        	
	        	}
	        	if((tableau[0][2]==x1 && tableau[1][1]==x1 && tableau[2][0]==x1) ||(tableau[0][2]==o1 && tableau[1][1]==o1 && tableau[2][0]==o1) )
	        	{
	        		x=false;
	        		o=false;
	        		JOptionPane.showMessageDialog(null, tableau[0][2]+" gange");
	        		return new result("center",321);
	        	}
	        	
	         }	         
	         
		}
		return null;
	}
	
	
	
}
