Java – Sending E-mail
Java
To send an e-mail using your Java Application is simple enough but to start with you should
have JavaMail API and Java Activation Framework (JAF) installed on your machine.
 You can download latest version of JavaMail (Version 1.2) from Java's standard
website.
 You can download latest version of JAF (Version 1.1.1) from Java's standard
website.
Download and unzip these files, in the newly created top level directories you will find a
number of jar files for both the applications. You need to add mail.jar
and activation.jar files in your CLASSPATH.
Send a Simple E-mail
Here is an example to send a simple e-mail from your machine. It is assumed that
your localhost is connected to the Internet and capable enough to send an e-mail.
// File Name SendEmail.java
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
public class SendEmail
{
public static void main(String [] args)
{
// Recipient's email ID needs to be mentioned.
String to = "abcd@gmail.com";
// Sender's email ID needs to be mentioned
String from = "web@gmail.com";
// Assuming you are sending email from localhost
String host = "localhost";
480Java
// Get system properties
Properties properties = System.getProperties();
// Setup mail server
properties.setProperty("mail.smtp.host", host);
// Get the default Session object.
Session session = Session.getDefaultInstance(properties);
try{
// Create a default MimeMessage object.
MimeMessage message = new MimeMessage(session);
// Set From: header field of the header.
message.setFrom(new InternetAddress(from));
// Set To: header field of the header.
message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
// Set Subject: header field
message.setSubject("This is the Subject Line!");
// Now set the actual message
message.setText("This is actual message");
// Send message
Transport.send(message);
System.out.println("Sent message successfully....");
}catch (MessagingException mex) {
mex.printStackTrace();
}
}
}
Compile and run this program to send a simple e-mail:
$ java SendEmail
Sent message successfully....
481Java
If you want to send an e-mail to multiple recipients then the following methods would be
used to specify multiple e-mail IDs:
void addRecipients(Message.RecipientType type, Address[] addresses)throws
MessagingException
Here is the description of the parameters:
 type: This would be set to TO, CC or BCC. Here CC represents Carbon Copy and
BCC represents Black Carbon Copy. ExampleMessage.RecipientType.TO
 addresses: This is an array of e-mail ID. You would need to use InternetAddress()
method while specifying email IDs.