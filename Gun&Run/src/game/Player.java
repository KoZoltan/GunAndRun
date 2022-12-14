package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.GuiScreen;

public class Player {

    private String nev;
    int db = 8;


    // adat tárolók
    private String[] sender = new String[db];
    private String[] receiver = new String[db];
    private String[] bsender = new String[db];
    private String[] breceiver = new String[db];
    private int[] status = new int[db];


    public Player(String nev){
        this.nev=nev;
        
    }

    
    
    
    public void baratOlvaso(){
    	File file = new File("Barik.txt");
        try (Scanner input = new Scanner(file)) {
            int i = 0;
            while (input.hasNextLine()) {
                String line = input.nextLine();

        
                String[] data = line.split(" ");

                this.bsender[i] = data[0];
                this.breceiver[i] = data[1];

                i++;
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }

    public void refresher(){
    	

        File file = new File("Szerver.txt");
        try (Scanner input = new Scanner(file)) {
            int i = 0;
            while (input.hasNextLine()) {
                String line = input.nextLine();

        
                String[] data = line.split(" ");

                this.sender[i] = data[0];
                this.receiver[i] = data[1];
                this.status[i] = Integer.parseInt(data[2]);

                i++;
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }

    public void printData(){
        System.out.println("Sender: " + Arrays.toString(sender));
        System.out.println("Reciever: " + Arrays.toString(receiver));
        System.out.println("Status: " + Arrays.toString(status));
    }


    public void listFriends() {
    	
    	for(int i = 0; i<db; i++) {
    		if(this.bsender[i]!=null) {
    			JFrame frame = new JFrame();
         		frame.setBounds(500, 230, 100, 100);
         		frame.setResizable(false);
         		frame.setVisible(true);
         		JLabel label = new JLabel();
         		label.setText("Fiktiv02 is your friend");
         		frame.add(label);
    		}
    	}
		
    }



    public String[] getFrineds(){
        
        String[] friends = new String[db];

        for(int i=0;i<db;i++){
            if(this.sender[i] == "Fiktiv02" && this.status[i]==1){
            
            	JFrame frame = new JFrame();
         		frame.setBounds(500, 230, 100, 100);
         		frame.setResizable(false);
         		frame.setVisible(true);
         		JLabel label = new JLabel();
         		label.setText("Fiktiv02");
         		frame.add(label);
                /*if(this.sender[i].equalsIgnoreCase(this.nev)){
                    friends[i]=this.receiver[i];
                }
                if(this.receiver[i].equalsIgnoreCase(this.nev)){
                    friends[i]=this.sender[i];
                }*/
            }


        }

        
		
        //System.out.println("Friends: " + Arrays.toString(friends));
        return friends;
    }









    public void getInvite(){
        String[] from = new String[db];

        for(int i =0;i<db;i++){
            if(sender[i]!=null && status[i]==1){
            	if(this.sender[i].equalsIgnoreCase("Fiktiv02")) {
            		
            		JFrame frame = new JFrame();
            		frame.setTitle("Incoming invites");
            		frame.setResizable(false);
            		//frame.setBounds(500, 230, 1000, 200);
            		frame.setSize(1000, 500);
            		frame.setLayout(null);
             		frame.setVisible(true);
            
             		JPanel p = new JPanel();
             		JPanel p2 = new JPanel();
             		JPanel p3 = new JPanel();
             		
             		p.setBounds(0, 0, 1000, 250);
             		//p.setBackground(Color.black);
             		
             		p2.setBounds(0, 250, 500, 250);
             		//p2.setBackground(Color.blue);
             		
             		p3.setBounds(500, 250, 500, 250);
             		//p3.setBackground(Color.green);
             		
             		frame.add(p);
             		frame.add(p2);
             		frame.add(p3);
             		
             		
             		JLabel label = new JLabel();
             		label.setText("Fiktiv02");
             		label.setHorizontalTextPosition(JLabel.CENTER);
             		label.setHorizontalAlignment(JLabel.LEFT);
             		label.setVerticalAlignment(JLabel.CENTER);
            
             		p.add(label);

             		JCheckBox c1 = new JCheckBox("ACCEPT");
             		JCheckBox c2 = new JCheckBox("REJECT");
             		c1.setHorizontalAlignment(JCheckBox.CENTER);
             		c1.addActionListener(new ActionListener() {
						
						@SuppressWarnings("deprecation")
						@Override
						public void actionPerformed(ActionEvent e1) {
							try { 
								FileWriter writer = new FileWriter("Barik.txt");
								BufferedWriter bw = new BufferedWriter(writer);
								bw.write("Fiktiv02");
								bw.write(" ");
								bw.write("Fiktiv01");
								bw.newLine();
							    bw.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
	             			
							
						}
					});
             		p.add(label);
             		p2.add(c1);
             		p3.add(c2);
             		
             		if(c1.isSelected()) { //ha a kis box be lett pipalva akko true
             			try { //nem hozza letre
							FileWriter writer = new FileWriter("Barik.txt");
							BufferedWriter bw = new BufferedWriter(writer);
							bw.write("Fiktiv02");
							bw.write(" ");
							bw.write("Fiktiv01");
							bw.newLine();
						    bw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
             			
             		}
             		
             		if(c2.isSelected()) {
             			//ezt old meg
             		}
             		
            	}
                
                /*if(receiver[i].equalsIgnoreCase(nev)){
                    from[i]=sender[i];
                }*/
            }
    
    
        }
    
    
        //System.out.println("From" + Arrays.toString(from));
    
        }










 

    public void sendInvite(String to){

        String text = this.nev+" "+ to +" "+"2";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"));


            writer.write(text + "\n");


            writer.close();
        } catch (IOException e) {

        }
        System.out.println("Sikeresen elküldted a kérelmet.");
    }
 



    public void reject(String from){
        
        for(int j=0;j<this.db;j++){
            if(this.sender[j] != null){
                if(this.sender[j].equalsIgnoreCase(from) && this.status[j]==2){
                    this.status[j] =3;
                }
            }
        }
    

        File file = new File("server1.txt");

            try {

                FileWriter writer = new FileWriter(file);


                writer.write("");
                writer.close();
            }catch (IOException e) {
                e.printStackTrace();
            }


            try {

                FileWriter writer = new FileWriter("server1.txt");

                int i =0;
                while(this.receiver[i]!=null){
                    writer.write(this.sender[i]+" "+this.receiver[i]+" "+this.status[i] + "\n");
                    i++;
                }

                writer.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
    }

    public void accept(String from){
        
        for(int j=0;j<this.db;j++){
            if(this.sender[j] != null){
                if(this.sender[j].equalsIgnoreCase(from) && this.status[j]==2){
                    this.status[j] =1;
                }
            }
        }
    

        File file = new File("server1.txt");

            try {

                FileWriter writer = new FileWriter(file);


                writer.write("");
                writer.close();
            }catch (IOException e) {
                e.printStackTrace();
            }


            try {

                FileWriter writer = new FileWriter("server1.txt");

                int i =0;
                while(this.receiver[i]!=null){
                    writer.write(this.sender[i]+" "+this.receiver[i]+" "+this.status[i] + "\n");
                    i++;
                }

                writer.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
    }
}


    





        



