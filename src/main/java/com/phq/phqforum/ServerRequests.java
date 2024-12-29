
package com.phq.phqforum;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.json.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.mail.*;
import java.util.Properties;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import java.security.SecureRandom;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
/**
 *
 * @author evanredmond
 */

public class ServerRequests {

    public static final String CRLF = "\r\n";
    ServerSocket s;
    
    protected ServerSocket getServerSocket(int port) throws Exception{
        
        return new ServerSocket(port);  
    }

    public void runServer(int port) throws Exception{
        
        s = getServerSocket(port);
        
        while(true) {
            
            try {
                System.out.println("server is running");
                Socket us = s.accept();
                Handler(us);
                
                
            } catch (IOException e) {
                System.err.println(e);
            }
            
        }
        
        
    }
   
    
    public void Handler(Socket s) throws Exception, MessagingException {
        
     
       
        
        new Thread(() -> {
        
        try {
            
       final InputStream is;
       final PrintWriter os;
       BCryptPasswordEncoder PE = new BCryptPasswordEncoder();
      BCryptPasswordEncoder PE2 = new BCryptPasswordEncoder();
      
           MimeMessage mesg;
           Session session;
           
            String from = s.getInetAddress().toString();
        System.out.println("Accepted connection from " + from);
        is = s.getInputStream();
          os = new PrintWriter(s.getOutputStream());
      
          
        byte[] buffer = new byte[1024];
        int bytesRead;
        Pattern p;
        Pattern p2;
        Pattern p3;
        Pattern p4;
        Pattern p5;
        Pattern p6;
        Pattern p7;
        Pattern p8;
        Pattern p9;
        Pattern p10;
        Pattern p11;
        Pattern p12;
        
        Matcher m;
        Matcher m2;
        Matcher m3;
        Matcher m4;
        Matcher m5;
        Matcher m6;
        Matcher m7;
        Matcher m8;
        Matcher m9;
        Matcher m10;
        Matcher m11;
        Matcher m12;
        
        while ((bytesRead = is.read(buffer)) != -1) {
            

           String data = new String(buffer, 0, bytesRead);
               
         String SP1 = "[$](four).*";
         String SP2 = "[&](two).*";
         String SP3 = "[@](one).*";
         String SP4 = "[&](thr).*";
         String SP5 = "[&](reg).*";
         String SP6 = "[&](log).*";
         String SP7 = "[&](email).*";
        String SP8 = "[&](E).*";
        String SP9 = "[&](pdit).*";
        String SP10 = "[&](D).*";
        String SP11 = "[&](K).*";
        String SP12 = "[$](five).*";
        
        

             p = Pattern.compile(SP1);
             p2 = Pattern.compile(SP2);
             p3 = Pattern.compile(SP3);
             p4 = Pattern.compile(SP4);
             p5 = Pattern.compile(SP5);
             p6 = Pattern.compile(SP6);
             p7 = Pattern.compile(SP7);
             p8 = Pattern.compile(SP8);
             p9 = Pattern.compile(SP9);
             p10 = Pattern.compile(SP10);
             p11 = Pattern.compile(SP11);
             p12 = Pattern.compile(SP12);
             
             m = p.matcher(data);
             m2 = p2.matcher(data);
             m3 = p3.matcher(data);
             m4 = p4.matcher(data);
             m5 = p5.matcher(data);
             m6 = p6.matcher(data);
             m7 = p7.matcher(data);
             m8 = p8.matcher(data);
             m9 = p9.matcher(data);
             m10 = p10.matcher(data);
             m11 = p11.matcher(data);
            
           
      
if (m.find()) {
    
    
     m12 = p12.matcher(m.group(0));
     
    if (m12.find()) {
        
            int num1 = m.group(0).indexOf("{");
            int num2 = m.group(0).indexOf("}");
        
       FetchDescription FD = new FetchDescription();
       
      JsonArray Desc = FD.found(m.group(0).substring(num1+7, num2-1));
      
      System.out.println("HERE IS args " + m.group(0).substring(num1+7, num2-1) );

                 os.print("HTTP/1.1 200 OK" + CRLF);
              os.print("Content-Type: text/plain; charset=utf-8" + CRLF);
             os.print("Access-Control-Allow-Origin:*" + CRLF);
             os.print("Access-Control-Allow-Headers: Content-Type" + CRLF);           
            os.print("Server: http://localhost:80/" + CRLF);
            
        os.print(CRLF);
      os.print(Desc);
       os.flush();
       os.close();
        
        
    } else {
    
    

int num1 = m.group(0).indexOf("{");
int num2 = m.group(0).indexOf("}");

        JsonArray jso = new getReplies().getReplies2(m.group(0).substring(num1+7, num2-1));
        IncrementViews IV = new IncrementViews();
        IV.inc(m.group(0).substring(num1+7, num2-1));

                 os.print("HTTP/1.1 200 OK" + CRLF);
              os.print("Content-Type: text/plain; charset=utf-8" + CRLF);
             os.print("Access-Control-Allow-Origin:*" + CRLF);
             os.print("Access-Control-Allow-Headers: Content-Type" + CRLF);           
            os.print("Server: http://localhost:80/" + CRLF);
            
        os.print(CRLF);
        os.print(jso);
       os.flush();
       os.close();
    }
    
} else if(m2.find()) {

int in1 = m2.group(0).indexOf("{");
int in2 = m2.group(0).lastIndexOf("}");

JsonArray jso2 = new fetchTopics().fetchTopics2(m2.group(0).substring(in1+7, in2-1));

               os.print("HTTP/1.1 200 OK" + CRLF);
              os.print("Content-Type: text/plain; charset=utf-8" + CRLF);
             os.print("Access-Control-Allow-Origin:*" + CRLF);
             os.print("Access-Control-Allow-Headers: Content-Type" + CRLF);           
            os.print("Server: http://localhost:80/" + CRLF);
            
        os.print(CRLF);
        os.print(jso2);
        os.flush(); //new addition
        os.close();

} 


else if(m3.find()) {


int m3int = m3.group(0).indexOf("{");
int m3int2 = m3.group(0).indexOf("}");
int m3int4 = m3.group(0).indexOf("myData");
int m3int3 = m3.group(0).lastIndexOf("}");
int m3int5 = m3.group(0).indexOf("@", 2);
int m3int6 = m3.group(0).lastIndexOf("@");
int m3int9 = m3.group(0).indexOf("@", m3int5 + 2);
int m3int7 = m3.group(0).indexOf("-");
int m3int8 = m3.group(0).lastIndexOf("-");


String m31 = m3.group(0).substring(m3int+7, m3int2-1);
//topic
String m32 = m3.group(0).substring(m3int4+9, m3int3-1);
//reply
String m33 = m3.group(0).substring(m3int5+1, m3int9);
//date
String m34 = m3.group(0).substring(m3int7+1, m3int8);
//user

insertReply it = new insertReply();
it.insertIt(m33, m31, m34, m32);

updateTopicDate UT = new updateTopicDate();
UT.update(m33, m31);
incrementReplies IR = new incrementReplies();
IR.inc(m31);
 os.flush(); 
       os.close();}



else if(m4.find()) {
    
    int ind2 = m4.group(0).lastIndexOf("@");
    int ind3 = m4.group(0).indexOf("@");
    int ind4 = m4.group(0).indexOf("@", ind3 + 1);
    int ind5 = m4.group(0).indexOf("{");
    int ind6 = m4.group(0).lastIndexOf("}");
    int ind7 = m4.group(0).indexOf("-");
    int ind8 = m4.group(0).lastIndexOf("-");
     int ind9 = m4.group(0).indexOf("=");
    int ind10 = m4.group(0).lastIndexOf("=");
    
    String g1 = m4.group(0).substring(5, ind4);
    String g2 = m4.group(0).substring(ind4+1, ind2);
    String g3 = m4.group(0).substring(ind5 + 7, ind6 -1);
    String g4 = m4.group(0).substring(ind7+1, ind8);
    String g5 = m4.group(0).substring(ind9+1, ind10);

insertTopic IT = new insertTopic();
IT.insertIt(g1, g2, g3, g4, g5);
        
    incrementTopics IT2 =  new incrementTopics();
   IT2.inc(g3);
    
    incrementLastPostT ILP = new incrementLastPostT();
    ILP.inc(g3, g4);

 os.flush(); 
       os.close();}

else if (m5.find()) {
    
    Properties props = new Properties();
     SecureRandom random = new SecureRandom(); 
     
   int randomInt = random.nextInt(100000000);
   int m5int = m5.group(0).indexOf("%");
    int m5int2 = m5.group(0).lastIndexOf("%");
    int m5int3 = m5.group(0).indexOf("=");
    int m5int4 = m5.group(0).lastIndexOf("=");
    int m5int7 = m5.group(0).indexOf("@");
    int m5int8 = m5.group(0).lastIndexOf("@");
 
    String m5s = m5.group(0).substring(m5int+1, m5int2);
    String m5s2 = m5.group(0).substring(m5int3+1, m5int4);
    String m5s4 = m5.group(0).substring(m5int7+1, m5int8);
   String BCm5s2 = PE.encode(m5s2);
   
    insertUser IU = new insertUser();
   IU.insertIt("1", m5s, BCm5s2, m5s4, from, randomInt);
      
          Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("forum@pharmacyhq.com", "ElOnWiLgRiD123#$"); 
            } 
        };
    
        props.put("mail.smtp.host","mail.pharmacyhq.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.port", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.starttls.enable","true"); 
        props.put("mail.smtp.ssl.enable","true"); 
 
    session = Session.getDefaultInstance(props, auth);
    session.setDebug(true);

        mesg = new MimeMessage(session);
        mesg.setFrom(new InternetAddress("forum@pharmacyhq.com"));
        InternetAddress toAddress = new InternetAddress(m5s4);
        mesg.addRecipient(Message.RecipientType.TO, toAddress);
        mesg.setSubject("Subject");
        mesg.setText("PharmacyHQ Discussion Forum "
                + " -"+ "please click to confirm email:  " +
                m5s + "  "  + "http://localhost:3000/ConfEmail2/"+ randomInt);
        Transport.send(mesg);
        
    
}

else if(m6.find()) {
    int m6i = m6.group(0).indexOf("=");
     int m6i2 = m6.group(0).lastIndexOf("=");
     int m6i3 = m6.group(0).indexOf("-");
     
     String user = m6.group(0).substring(m6i+1, m6i2);
     String PW = m6.group(0).substring(m6i2+1, m6i3);

     userFound uf = new userFound();
     String use = uf.found(user, PW, PE);
                os.print("HTTP/1.1 200 OK" + CRLF);
              os.print("Content-Type: text/plain; charset=utf-8" + CRLF);
             os.print("Access-Control-Allow-Origin:*" + CRLF);
             os.print("Access-Control-Allow-Headers: Content-Type" + CRLF);           
            os.print("Server: http://localhost:80/" + CRLF); 
        os.print(CRLF);
        os.print(use);
        os.flush(); 
       os.close();
     
    
} else if(m7.find()) {
    
    
      int m7i = m7.group(0).indexOf("{");
     int m7i2 = m7.group(0).lastIndexOf("}");
     
     String emailCode = m7.group(0).substring(m7i+7, m7i2-1);

    int EC = Integer.parseInt(emailCode);
    System.out.println("emailCode String: " + emailCode);
    
    confirmEmail CE = new confirmEmail();
    CE.conf(EC);

} else if (m8.find()) {
    
    int m8i = m8.group(0).indexOf("=");
    int m8i2 = m8.group(0).lastIndexOf("=");
    
    String user1 = m8.group(0).substring(m8i+1, m8i2);
    
    returnID RID = new returnID();
    String id3 = RID.found(user1);
    
              Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("forum@pharmacyhq.com", "ElOnWiLgRiD123#$");
            } 
        };
    
        Properties props = new Properties();
        props.put("mail.smtp.host","mail.pharmacyhq.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.port", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.starttls.enable","true"); 
        props.put("mail.smtp.ssl.enable","true"); 
  
    session = Session.getDefaultInstance(props, auth);
    session.setDebug(true);

         mesg = new MimeMessage(session);
        mesg.setFrom(new InternetAddress("forum@pharmacyhq.com"));
        InternetAddress toAddress = new InternetAddress(user1);
        mesg.addRecipient(Message.RecipientType.TO, toAddress);
        mesg.setSubject("Subject");
        mesg.setText("PharmacyHQ Discussion Forum "
                + " -"+ "please click to confirm email: "+ 
                "http://localhost:3000/ChangePW/" + id3 + "/" + user1 );
        Transport.send(mesg);
      
} else if (m9.find()) {
    
    //"&pdit"
    
    int m9i = m9.group(0).indexOf("=");
    int m9i2 = m9.group(0).lastIndexOf("=");
    int m9i3 = m9.group(0).indexOf("-");
    int m9i4 = m9.group(0).lastIndexOf("-");
    
    String PW2 = m9.group(0).substring(m9i+1, m9i2);
    String ID3 = m9.group(0).substring(m9i2+8, m9i3-2);
    String email2 = m9.group(0).substring(m9i3+8, m9i4-2);
    String PWE2 = PE2.encode(PW2);
    
 updatePW UPW = new updatePW();
 UPW.now(email2, ID3, PWE2);
 
} else if (m10.find()) {
    
     int m10i = m10.group(0).indexOf("=");
    int m10i2 = m10.group(0).lastIndexOf("=");
    
      String email3 = m10.group(0).substring(m10i+1, m10i2);
      
      deleteUser DU = new deleteUser();
      DU.del(email3);  
} else if (m11.find()) {
            
  fetchCommunities FC = new fetchCommunities();
  FC.Fetch();
              os.print("HTTP/1.1 200 OK" + CRLF);
              os.print("Content-Type: text/plain; charset=utf-8" + CRLF);
             os.print("Access-Control-Allow-Origin:*" + CRLF);
             os.print("Access-Control-Allow-Headers: Content-Type" + CRLF);           
            os.print("Server: http://localhost:80/" + CRLF);
        os.print(CRLF);
        os.print(FC.Fetch());
        os.flush(); 
       os.close();
  
        } 
            } 

   
        }catch (IOException e) { System.err.println("THIS WAS CAUGHT: " + e);} catch (SQLException ex) {
            Logger.getLogger(ServerRequests.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (AddressException ex) {
                Logger.getLogger(ServerRequests.class.getName()).log(Level.SEVERE, null, ex);
            }catch (MessagingException ex) {
                Logger.getLogger(ServerRequests.class.getName()).log(Level.SEVERE, null, ex);
            }
  }).start();  
    } 
}
