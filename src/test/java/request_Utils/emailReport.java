package request_Utils;

import javax.mail.PasswordAuthentication;
import java.io.IOException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import request_Utils.globalVar;

    public class emailReport {
	public static void SendTestReport() throws IOException {
		Properties props                                              = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("jyotiprakash@valuebound.com", "imprototype");
			}
		});
		try {
			MimeMultipart content                                    = new MimeMultipart();
			Multipart multipart                                      = new MimeMultipart();
			Message message                                          = new MimeMessage(session);
			message.setFrom(new InternetAddress("jyotiprakash@valuebound.com"));
			message.setSubject("Kendall Hunt");
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("jyotiqa009@gmail.com"));
		    //message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("jyotiqa009@gmail.com,bspavan@valuebound.com,girish.v@valuebound.com"));

			BodyPart messageBodyPart1                                = new MimeBodyPart();
			// messageBodyPart1.setText("Cypress Test Status");

			String htmlText                                          = "<H1>Cucumber Report</H1><img src=\"cid:image\">";
			messageBodyPart1.setContent(htmlText, "text/html");
			multipart.addBodyPart(messageBodyPart1);

			MimeBodyPart messageBodyPart2                            = new MimeBodyPart();
			MimeBodyPart messageBodyPart3                            = new MimeBodyPart();

				DataSource source1                                   = new FileDataSource(globalVar.SystemExtentReportPath);
				messageBodyPart2.setDataHandler(new DataHandler(source1));
				messageBodyPart2.setFileName(globalVar.SystemExtentReportPath);
				multipart.addBodyPart(messageBodyPart2);
				message.setContent(multipart);
				Transport.send(message);
				System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	  }
     }
